package com.hithinksoft.homepage.web.contact;

import com.hithinksoft.homepage.domain.contact.ContactRequest;
import com.hithinksoft.homepage.domain.contact.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzs on 2016/7/19.
 */
@RequestMapping("/contacts")
@Controller
public class ContactsIndexController {

    @Autowired
    private ContactRequestRepository contactRequestRepository;

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private MessageSource messageSource;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.administrator}")
    private String to;

    @RequestMapping
    public String index(ContactRequest contactRequest) {
        return "contacts/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map create(@RequestBody @Valid ContactRequest contactRequest, BindingResult result) {
        Map<String, String> map = new HashMap<>();
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            map.put("message", "fail");
            return map;
        }
        contactRequestRepository.save(contactRequest);
        sendMail(contactRequest);
        return map;
    }

    //发送邮件
    private void sendMail(ContactRequest contactRequest) {
        MimeMessage message = sender.createMimeMessage();
        String content = contactRequest.getRequirementDescription() == null ? "" : contactRequest.getRequirementDescription();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            StringBuilder subject = new StringBuilder(messageSource.getMessage("view.contactus.letter.info", null, null));
            subject.append(contactRequest.getEnterpriseName());
            helper.setSubject(subject.toString());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("联系人：").append(contactRequest.getContact()).append("\n");
            stringBuilder.append("联系电话：").append(contactRequest.getTelephone()).append("\n");
            stringBuilder.append("e-mail：").append(contactRequest.getEmail()).append("\n");
            stringBuilder.append("\n").append(contactRequest.getRequirementDescription());
            helper.setText(stringBuilder.toString());
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}

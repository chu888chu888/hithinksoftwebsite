package com.hithinksoft.homepage.web.admin.contactreuqest;

import com.hithinksoft.homepage.domain.contact.ContactRequest;
import com.hithinksoft.homepage.domain.contact.ContactRequestRepository;
import com.hithinksoft.homepage.domain.contact.ContactRequestStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Li_Zhensong on 2016/9/9.
 */
@RequestMapping("/admin/contactrequest")
@Controller
public class ContactRequestDetailController {

    @Autowired
    private ContactRequestRepository contactRequestRepository;

    //显示联系我们的详细信息
    @RequestMapping(value = "/{contactRequestId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable Long contactRequestId, Integer page, String method, Model model) {
        ContactRequest contactRequest = contactRequestRepository.findOne(contactRequestId);
        if (ContactRequestStatus.UNREAD.equals(contactRequest.getContactRequestStatus())) {
            contactRequest.setContactRequestStatus(ContactRequestStatus.READ);
            contactRequestRepository.save(contactRequest);
        }
        model.addAttribute("contactRequest", contactRequest);
        model.addAttribute("page", page);
        model.addAttribute("method", method);
        return "admin/contactrequest/detail";
    }
}

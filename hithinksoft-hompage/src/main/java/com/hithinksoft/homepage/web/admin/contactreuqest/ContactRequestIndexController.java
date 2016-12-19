package com.hithinksoft.homepage.web.admin.contactreuqest;

import com.hithinksoft.homepage.domain.contact.ContactRequest;
import com.hithinksoft.homepage.domain.contact.ContactRequestRepository;
import com.hithinksoft.homepage.domain.contact.ContactRequestStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

/**
 * Created by Shuzhen on 2016/8/23.
 */
@RequestMapping("/admin/contactrequests")
@Controller
public class ContactRequestIndexController {

    @Autowired
    private ContactRequestRepository contactRequestRepository;

    //显示全部的联系我们信息
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String showAll(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<ContactRequest> contactRequests = contactRequestRepository.findByContactRequestStatusIn(pageable, ContactRequestStatus.READ, ContactRequestStatus.UNREAD);
        model.addAttribute("contactRequests", contactRequests);
        model.addAttribute("method", "all");
        return "admin/contactrequest/index";
    }

    //显示未读的联系我们信息
    @RequestMapping(value = "/unread", method = RequestMethod.GET)
    public String showUnread(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<ContactRequest> contactRequests = contactRequestRepository.findByContactRequestStatus(ContactRequestStatus.UNREAD, pageable);
        model.addAttribute("contactRequests", contactRequests);
        model.addAttribute("method", "unread");
        return "admin/contactrequest/index";
    }

    //显示已读的联系我们的信息
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String showRead(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<ContactRequest> contactRequests = contactRequestRepository.findByContactRequestStatus(ContactRequestStatus.READ, pageable);
        model.addAttribute("contactRequests", contactRequests);
        model.addAttribute("method", "read");
        return "admin/contactrequest/index";
    }

    //显示已删除的联系我们的信息
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showDelete(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<ContactRequest> contactRequests = contactRequestRepository.findByContactRequestStatus(ContactRequestStatus.DELETE, pageable);
        model.addAttribute("contactRequests", contactRequests);
        model.addAttribute("method", "showdelete");
        return "admin/contactrequest/index";
    }


    //删除一条联系我们的信息
    @RequestMapping(value = "/{contactRequestId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long contactRequestId) {
        ContactRequest contactRequest = contactRequestRepository.findOne(contactRequestId);
        if (ContactRequestStatus.DELETE.equals(contactRequest.getContactRequestStatus())) {
            contactRequest.setContactRequestStatus(ContactRequestStatus.COMPLETELYDELETE);
            contactRequestRepository.save(contactRequest);
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("CRIC#showDelete").build();
        } else {
            contactRequest.setContactRequestStatus(ContactRequestStatus.DELETE);
            contactRequestRepository.save(contactRequest);
            if (ContactRequestStatus.READ.equals(contactRequest.getContactRequestStatus())) {
                return "redirect:" + MvcUriComponentsBuilder.fromMappingName("CRIC#showRead").build();
            } else if (ContactRequestStatus.UNREAD.equals(contactRequest.getContactRequestStatus())) {
                return "redirect:" + MvcUriComponentsBuilder.fromMappingName("CRIC#showUnread").build();
            } else {
                return "redirect:" + MvcUriComponentsBuilder.fromMappingName("CRIC#showAll").build();
            }
        }
    }
}

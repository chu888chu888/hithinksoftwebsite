package com.hithinksoft.homepage.web.admin.user;

import com.hithinksoft.homepage.domain.group.Group;
import com.hithinksoft.homepage.domain.group.GroupRepository;
import com.hithinksoft.homepage.validation.GroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@RequestMapping("/admin/groups")
@Controller
public class GroupCreateController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupValidator groupValidator;

    @InitBinder
    protected void initBinder(DataBinder binder) {
        binder.addValidators(groupValidator);
    }

    @RequestMapping(value = "/create")
    public String newly(Model model) {
        model.addAttribute("group",new Group());
        return "admin/groups/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("group") Group group, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/groups/create";
        }
            groupRepository.save(group);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GIC#index").build();
    }

}

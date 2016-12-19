package com.hithinksoft.homepage.web.admin.user;

import com.hithinksoft.homepage.domain.permission.Permission;
import com.hithinksoft.homepage.domain.permission.PermissionRepository;
import com.hithinksoft.homepage.validation.PermissionValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;

/**
 * Created by Li_Zhensong on 2016/8/15.
 */
@RequestMapping("/admin/authorities")
@Controller
public class AuthorityCreateController {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionValidator permissionValidator;

    @InitBinder
    protected void initBinder(DataBinder binder) {
        binder.addValidators(permissionValidator);
    }

    @RequestMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("permission", new Permission());
        return "admin/authorities/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("permission") Permission permission, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/authorities/create";
        }
        permissionRepository.save(permission);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AIC#index").build();
    }

}

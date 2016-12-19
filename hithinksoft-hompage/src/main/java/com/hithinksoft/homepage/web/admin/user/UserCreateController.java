package com.hithinksoft.homepage.web.admin.user;

import com.hithinksoft.homepage.domain.authority.RoleEnum;
import com.hithinksoft.homepage.domain.group.Group;
import com.hithinksoft.homepage.domain.group.GroupRepository;
import com.hithinksoft.homepage.domain.user.User;
import com.hithinksoft.homepage.domain.user.UserRepository;
import com.hithinksoft.homepage.validation.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import java.util.List;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@RequestMapping("/admin/users")
@Controller
public class UserCreateController {
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("roles")
    public RoleEnum[] roleList() {
        return RoleEnum.values();
    }

    @InitBinder
    protected void initBinder(DataBinder binder) {
        binder.addValidators(userValidator);
    }

    @RequestMapping(value = "/create")
    public String create(Model model) {
        List<Group> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);
        model.addAttribute("user", new User());
        return "admin/users/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Group> groups = groupRepository.findAll();
            model.addAttribute("groups", groups);
            return "admin/users/create";
        }
        user.ToUser(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("UIC#index").build();
    }

}

package com.hithinksoft.homepage.web.admin.user;

import com.hithinksoft.homepage.domain.authority.Authorities;
import com.hithinksoft.homepage.domain.authority.AuthorityRepository;
import com.hithinksoft.homepage.domain.authority.RoleEnum;
import com.hithinksoft.homepage.domain.group.Group;
import com.hithinksoft.homepage.domain.group.GroupRepository;
import com.hithinksoft.homepage.domain.user.User;
import com.hithinksoft.homepage.domain.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@RequestMapping("/admin/users")
@Controller
public class UserIndexController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("roles")
    public RoleEnum[] roleList() {
        return RoleEnum.values();
    }

    @RequestMapping
    public String index(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<User> users = userRepository.findAll(pageable);
        model.addAttribute("users", users);
        List<Authorities> authorities = authorityRepository.findAll();
        model.addAttribute("authorities", authorities);
        List<Group> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);
        return "admin/users/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(User user) {
        String password;
        User user1=userRepository.findById(user.getId());
        if(user1.getPassword().equals(user.getPassword())){
            password=user.getPassword();
        }
        else {
            password=passwordEncoder.encode(user.getPassword());
        }
        user.ToUser(password);
        userRepository.save(user);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("UIC#index").build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        userRepository.delete(Long.valueOf(id));
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("UIC#index").build();
    }

}

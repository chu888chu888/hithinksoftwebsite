package com.hithinksoft.homepage.web.admin.user;

import com.hithinksoft.homepage.domain.permission.Permission;
import com.hithinksoft.homepage.domain.permission.PermissionRepository;

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
 * Created by Li_Zhensong on 2016/8/15.
 */
@RequestMapping("/admin/authorities")
@Controller
public class AuthorityIndexController {

    @Autowired
    private PermissionRepository permissionRepository;

    @RequestMapping
    public String index(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<Permission> authorities = permissionRepository.findAll(pageable);
        model.addAttribute("authorities", authorities);
        return "admin/authorities/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(Permission permission) {
        permissionRepository.save(permission);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AIC#index").build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        permissionRepository.delete(Long.valueOf(id));
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AIC#index").build();
    }

}

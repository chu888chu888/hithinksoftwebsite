package com.hithinksoft.homepage.web.admin.user;

import com.hithinksoft.homepage.application.UserManageService;
import com.hithinksoft.homepage.domain.group.Group;
import com.hithinksoft.homepage.domain.group.GroupRepository;
import com.hithinksoft.homepage.domain.permission.Permission;
import com.hithinksoft.homepage.domain.permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.Set;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@RequestMapping("/admin/groups")
@Controller
public class GroupIndexController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserManageService userManageService;

    @RequestMapping
    public String index(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<Group> groups = groupRepository.findAll(pageable);
        model.addAttribute("groups", groups);
        List<Permission> permissions = permissionRepository.findAll();
        model.addAttribute("permissions", permissions);
        return "admin/groups/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(Group group) {
        groupRepository.save(group);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GIC#index").build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        try {
            groupRepository.delete(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GIC#index").build();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/authorities", method = RequestMethod.GET)
    public Set<Permission> showGroupAuthority(@PathVariable String id) {
        Group group = groupRepository.findOne(Long.valueOf(id));
        return group.getAuthorities();
    }

    @RequestMapping(value = "/{id}/authorities", method = RequestMethod.PUT)
    public String updateAuthority(@PathVariable String id, @RequestParam(value = "authority") String... authorities) {
        userManageService.updateGroupAuthority(id, authorities);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GIC#index").build();
    }

}

package com.hithinksoft.homepage.application.impl;

import com.hithinksoft.homepage.application.UserManageService;
import com.hithinksoft.homepage.domain.group.Group;
import com.hithinksoft.homepage.domain.group.GroupRepository;
import com.hithinksoft.homepage.domain.permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void updateGroupAuthority(String groupId, String... authorities) {
        Group group = groupRepository.findOne(Long.valueOf(groupId));
        group.getAuthorities().removeIf(it -> it.isEnabled());
        group.getAuthorities().addAll(permissionRepository.findByAuthorityIn(authorities));
        groupRepository.save(group);
    }

}

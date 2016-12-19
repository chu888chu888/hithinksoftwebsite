package com.hithinksoft.homepage.validation;

import com.hithinksoft.homepage.domain.permission.Permission;
import com.hithinksoft.homepage.domain.permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@Component
public class PermissionValidator implements Validator {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Permission.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Permission permission = (Permission) obj;
        if (permissionRepository.findByName(permission.getName()) != null) {
            errors.rejectValue("name", "constraints.permission.name.exists");
        }
        if (permissionRepository.findByAuthority(permission.getAuthority()) != null) {
            errors.rejectValue("authority", "constraints.permission.authority.exists");
        }
    }

}

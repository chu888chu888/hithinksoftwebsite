package com.hithinksoft.homepage.validation;

import com.hithinksoft.homepage.domain.group.Group;
import com.hithinksoft.homepage.domain.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@Component
public class GroupValidator implements Validator {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Group.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Group group = (Group) obj;
        if (groupRepository.findByGroupName(group.getGroupName()) != null) {
            errors.rejectValue("groupName", "constraints.group.groupName.exists");
        }
    }

}

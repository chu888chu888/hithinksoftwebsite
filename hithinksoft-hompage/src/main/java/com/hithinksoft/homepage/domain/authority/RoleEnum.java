package com.hithinksoft.homepage.domain.authority;


import com.hithinksoft.homepage.domain.shared.ValueObject;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
public enum RoleEnum implements ValueObject<RoleEnum> {
    ROLE_USER(""), ROLE_ROOT("ROOT"), ROLE_ADMIN("ADMIN");

    @Override
    public boolean sameValueAs(RoleEnum other) {
        return other == this;
    }

    private String groupname;

    private RoleEnum(String groupName) {
        this.groupname = groupName;
    }

    public String getGroupname() {
        return groupname;
    }

}

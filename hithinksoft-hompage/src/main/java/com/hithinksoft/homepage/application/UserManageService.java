package com.hithinksoft.homepage.application;


import com.hithinksoft.homepage.domain.user.User;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
public interface UserManageService {
    /**
     * 修改用户组权限
     *
     * @param groupId     .
     * @param authorities .
     */
    void updateGroupAuthority(String groupId, String... authorities);
}

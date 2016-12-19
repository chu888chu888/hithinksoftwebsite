package com.hithinksoft.homepage.domain.permission;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByAuthority(String authority);

    Set<Permission> findByAuthorityIn(String... authorities);

    Permission findByName(String name);

}
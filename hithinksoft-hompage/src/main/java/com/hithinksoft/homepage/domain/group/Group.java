package com.hithinksoft.homepage.domain.group;

import com.hithinksoft.homepage.domain.permission.Permission;
import com.hithinksoft.homepage.domain.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    @NotEmpty
    @Column(name = "group_name", unique = true)
    private String groupName;

    @NotEmpty
    private String name;

    private String description;

    private boolean enabled;

    @ManyToMany
    @JoinTable(name = "group_authorities",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority", referencedColumnName = "authority")})
    private Set<Permission> authorities;

}

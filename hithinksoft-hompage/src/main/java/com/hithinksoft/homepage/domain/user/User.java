package com.hithinksoft.homepage.domain.user;

import com.hithinksoft.homepage.domain.authority.Authorities;
import com.hithinksoft.homepage.domain.authority.RoleEnum;
import com.hithinksoft.homepage.domain.group.Group;
import com.hithinksoft.homepage.domain.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Size(min = 2, max = 12)
    @Column(length = 50, unique = true)
    private String username;

    @Column(length = 255, nullable = false)
    private String password;

    private boolean enabled;

    @NotEmpty
    @Column(length = 10, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "group_members"
            , joinColumns = {@JoinColumn(name = "username", referencedColumnName = "username")}
            , inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private Set<Group> groups = new HashSet<Group>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Authorities> authorities;

    public User() {

    }

    public User(Long id, String username, String password, String name, boolean enabled, List<Authorities> authorities, Set<Group> groups) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
        this.authorities = authorities;
        this.groups = groups;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Transient
    private RoleEnum role;
    @Transient
    private Group group;
    @Transient
    private String repassword;

    public List<Authorities> getListAuthorities() {
        List<Authorities> authoritiesList = new ArrayList<Authorities>();
        Authorities authorities = new Authorities(this.getUsername(), this.role);
        authoritiesList.add(authorities);
        return authoritiesList;
    }

    private Set<Group> getSetGroups() {
        Set<Group> groups = new HashSet<Group>();
        groups.add(this.group);
        return groups;
    }

    public void ToUser(String password) {
        this.authorities = getListAuthorities();
        this.password=password;
        this.groups = getSetGroups();
    }
}

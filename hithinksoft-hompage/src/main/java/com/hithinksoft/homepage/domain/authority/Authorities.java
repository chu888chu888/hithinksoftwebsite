package com.hithinksoft.homepage.domain.authority;

import com.hithinksoft.homepage.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@Setter
@Getter
@Entity
public class Authorities {
    @Id
    @Column(length = 50, unique = true)
    private String username;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private RoleEnum authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false, insertable = false, updatable = false)
    private User user;

    public Authorities() {

    }

    public Authorities(String username, RoleEnum authority) {
        this.username = username;
        this.authority = authority;
    }
}

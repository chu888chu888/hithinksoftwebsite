package com.hithinksoft.homepage.domain.permission;

import com.hithinksoft.homepage.domain.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@Setter
@Getter
@Entity
@Table(name = "permissions")
public class Permission extends BaseEntity {

    @NotEmpty
    @Column(unique = true)
    @Pattern(regexp = "^[AUTH_]+.*$")
    private String authority;

    @NotEmpty
    @Length(max = 10)
    @Column(unique = true)
    private String name;

    @NotNull
    private String path;

    private boolean enabled;
}
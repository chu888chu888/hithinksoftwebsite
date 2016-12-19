package com.hithinksoft.homepage.domain.contact;

import com.hithinksoft.homepage.domain.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

/**
 * Created by lzs on 2016/7/25.
 */
@Getter
@Setter
@Entity
@Table(name = "contact_request")
public class ContactRequest extends BaseEntity {

    @Length(min = 2, max = 50)
    private String enterpriseName;

    @Length(min = 2, max = 50)
    private String contact;

    @Length(min = 7, max = 13)
    private String telephone;

    @Length(min = 2, max = 50)
    @Email
    private String email;

    @URL
    private String website;

    @NotEmpty
    @Lob
    private String requirementDescription;

    @Enumerated(EnumType.STRING)
    @Column(length = 25, nullable = false)
    private ContactRequestStatus contactRequestStatus = ContactRequestStatus.UNREAD;
}

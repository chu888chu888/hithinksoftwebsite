package com.hithinksoft.homepage.domain.job;

import com.hithinksoft.homepage.domain.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Min;

/**
 * Created by Shuzhen on 2016/7/26.
 */
@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {
    @NotEmpty
    @Column
    private String jobName;
    @NotEmpty
    @Column
    private String location;
    @Min(value = 0)
    private Integer numberRequirement;
    @NotEmpty
    @Lob
    @Column
    private String jobContent;
}

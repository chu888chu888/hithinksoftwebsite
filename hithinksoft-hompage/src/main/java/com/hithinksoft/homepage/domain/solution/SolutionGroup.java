package com.hithinksoft.homepage.domain.solution;

import com.hithinksoft.homepage.domain.shared.BaseEntity;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

/**
 * Created by Li_Zhensong on 2016/8/19.
 */
@Getter
@Setter
@Entity
@Table(name = "solution_group")
public class SolutionGroup extends BaseEntity {

    @NotEmpty
    private String name;
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE}, mappedBy = "solutionGroup")
    private Set<Solution> solutions;


}

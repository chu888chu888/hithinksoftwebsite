package com.hithinksoft.homepage.domain.news;


import com.hithinksoft.homepage.domain.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;


/**
 * Created by ksdhc on 2016/7/28.
 */
@Getter
@Setter
@Entity
@Table(name = "news")
public class News extends BaseEntity {

    @Length(min = 1, max = 50)
    @Column(length = 250, nullable = false)
    private String title;
//    @Column(length = 250, nullable = false)
//    private String image;
    @Column(length = 250, nullable = false)
    private String thumb;
    @Column(nullable = false)
    private boolean popular;
    @Lob
    private String digest;
    @Lob
    private String detail;

}

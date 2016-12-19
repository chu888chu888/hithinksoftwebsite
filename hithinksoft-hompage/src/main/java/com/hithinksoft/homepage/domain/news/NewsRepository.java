package com.hithinksoft.homepage.domain.news;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * Created by ksdhc on 2016/7/28.
 */
public interface NewsRepository extends JpaRepository<News, Long>, Repository<News, Long> {
    Page<News> findByTitleContaining(String search, Pageable pageable);

    List<News> findTop3ByOrderByCreatedAtDesc();

    List<News> findTop3ByPopularOrderByCreatedAtDesc(Boolean popular);

    News findOneById(Long id);
}

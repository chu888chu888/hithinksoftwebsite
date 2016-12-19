package com.hithinksoft.homepage.web.news;

import com.hithinksoft.homepage.domain.news.News;
import com.hithinksoft.homepage.domain.news.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Dates;

import java.util.List;
import java.util.Locale;

/**
 * Created by ksdhc on 2016/8/3.
 */
@RequestMapping("/news")
@Controller
public class NewsShowController {

    @Autowired
    private NewsRepository newsRepository;

    @ModelAttribute("recent")
    public List<News> recent() {
        return newsRepository.findTop3ByOrderByCreatedAtDesc();
    }

    @ModelAttribute("popular")
    public List<News> popular() {
        return newsRepository.findTop3ByPopularOrderByCreatedAtDesc(true);
    }

    @ModelAttribute("dates")
    public Dates dates() {
        return new Dates(Locale.ENGLISH);
    }

    @RequestMapping("/{id}/show")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("news", newsRepository.findOneById(id));
        return "news/show";
    }
}



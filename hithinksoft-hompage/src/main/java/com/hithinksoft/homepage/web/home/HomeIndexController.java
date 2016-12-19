package com.hithinksoft.homepage.web.home;

import com.hithinksoft.homepage.domain.news.News;
import com.hithinksoft.homepage.domain.news.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Dates;

import java.util.List;
import java.util.Locale;

/**
 * Created by ksdhc on 2016-08-17.
 */
@Controller
@RequestMapping("/")
public class HomeIndexController {
    @Autowired
    private NewsRepository newsRepository;

    @ModelAttribute("recent")
    public List<News> recent() {
        List<News> newses = newsRepository.findTop3ByOrderByCreatedAtDesc();
        for (News news : newses) {
            if (news.getDigest().length() > 91) {
                String substring = news.getDigest().substring(0, 90);
                if (substring.endsWith(">")) {
                    news.setDigest(substring);
                } else {
                    news.setDigest(substring + "...");
                }
            }
        }
        return newses;
    }

    @ModelAttribute("dates")
    public Dates dates() {
        return new Dates(Locale.ENGLISH);
    }

    @RequestMapping
    public String home() {
        return "home/index";
    }

}

package com.hithinksoft.homepage.web.news;

import com.hithinksoft.homepage.domain.news.News;
import com.hithinksoft.homepage.domain.news.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Dates;

import java.util.List;
import java.util.Locale;


/**
 * Created by lzs on 2016/7/21.
 */
@RequestMapping("/news")
@Controller
public class NewsListController {

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

    @RequestMapping
    public String page(@PageableDefault(value = 4, direction = Sort.Direction.DESC, sort = "createdAt") Pageable pageable, Model model) {
        Page<News> newses = newsRepository.findAll(pageable);
        for (News news : newses) {
            if (news.getDigest().length() > 251) {
                String substring = news.getDigest().substring(0, 250);
                if (substring.endsWith(">")) {
                    news.setDigest(substring);
                } else {
                    news.setDigest(substring + "...");
                }
            }
        }
        model.addAttribute("news", newses);
        return "news/index";
    }

    @RequestMapping("/query")
    public String query(@PageableDefault(value = 4, direction = Sort.Direction.DESC, sort = "createdAt") Pageable pageable, @RequestParam(value = "search") String search, Model model) {
        model.addAttribute("news", newsRepository.findByTitleContaining(search, pageable));
        model.addAttribute("search", search);
        return "news/index";
    }

}

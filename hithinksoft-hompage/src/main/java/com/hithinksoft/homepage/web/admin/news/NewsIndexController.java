package com.hithinksoft.homepage.web.admin.news;

import com.hithinksoft.homepage.domain.news.News;
import com.hithinksoft.homepage.domain.news.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

/**
 * Created by Li_Zhensong on 2016/8/22.
 */
@RequestMapping("/admin/news")
@Controller
public class NewsIndexController {

    @Autowired
    NewsRepository newsRepository;

    @RequestMapping
    public String index(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<News> newses = newsRepository.findAll(pageable);
        model.addAttribute("newses", newses);
        return "admin/news/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        newsRepository.delete(Long.valueOf(id));
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("NIC#index").build();
    }
}

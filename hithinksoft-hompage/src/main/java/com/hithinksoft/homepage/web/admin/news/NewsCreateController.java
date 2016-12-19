package com.hithinksoft.homepage.web.admin.news;

import com.hithinksoft.homepage.domain.news.News;
import com.hithinksoft.homepage.domain.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;

/**
 * Created by Li_Zhensong on 2016/8/22.
 */
@RequestMapping("/admin/news")
@Controller
public class NewsCreateController {

    @Autowired
    NewsRepository newsRepository;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String editor(@PathVariable long id,Model model){
        model.addAttribute("news",newsRepository.findOne(id));
        return "admin/news/create";
    }

    @RequestMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("news", new News());
        return "admin/news/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("news") @Valid News news, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/news/create";
        }
        newsRepository.save(news);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("NIC#index").build();
    }
}

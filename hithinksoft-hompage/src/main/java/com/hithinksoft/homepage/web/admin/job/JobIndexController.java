package com.hithinksoft.homepage.web.admin.job;

import com.hithinksoft.homepage.domain.job.Job;
import com.hithinksoft.homepage.domain.job.JobRepository;

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
 * Created by Yoyoko on 2016/8/23.
 */
@Controller
@RequestMapping("/admin/jobs")
public class JobIndexController {
    @Autowired
    private JobRepository jobRepository;

    @RequestMapping
    public String index(@PageableDefault(page = 0, value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                        Model model) {
        Page<Job> page = jobRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "admin/jobs/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        jobRepository.delete(id);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("JIC#index").build();
    }
}

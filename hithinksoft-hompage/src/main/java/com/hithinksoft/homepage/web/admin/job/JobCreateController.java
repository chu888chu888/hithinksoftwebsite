package com.hithinksoft.homepage.web.admin.job;

import com.hithinksoft.homepage.domain.job.Job;
import com.hithinksoft.homepage.domain.job.JobRepository;

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
 * Created by Yoyoko on 2016/8/23.
 */
@Controller
@RequestMapping("/admin/jobs")
public class JobCreateController {
    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editor(@PathVariable long id, Model model) {
        model.addAttribute("job", jobRepository.findOne(id));
        return "admin/jobs/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("job", new Job());
        return "admin/jobs/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("job") @Valid Job job, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/jobs/create";
        }
        jobRepository.save(job);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("JIC#index").build();

    }
}

package com.hithinksoft.homepage.web.job;

import com.hithinksoft.homepage.domain.job.Job;
import com.hithinksoft.homepage.domain.job.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Shuzhen on 2016/8/1.
 */
@Controller
@RequestMapping("/job")
public class JobListController {
    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "job/index";
    }

}

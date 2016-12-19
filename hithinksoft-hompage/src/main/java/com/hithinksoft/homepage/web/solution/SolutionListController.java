package com.hithinksoft.homepage.web.solution;

import com.hithinksoft.homepage.domain.solution.SolutionGroup;
import com.hithinksoft.homepage.domain.solution.SolutionGroupRepository;
import com.hithinksoft.homepage.domain.solution.Solution;
import com.hithinksoft.homepage.domain.solution.SolutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

/**
 * Created by Li_Zhensong on 2016/8/19.
 */
@RequestMapping("/solution")
@Controller
public class SolutionListController {

    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private SolutionGroupRepository solutionGroupRepository;

    @RequestMapping
    public String index(@ModelAttribute("id") @Valid Long id, Model model) {
        List<SolutionGroup> solutionGroups = solutionGroupRepository.findAll();
        Solution solutions1 = solutionRepository.findOne(id);
        model.addAttribute("solutions1", solutions1);
        model.addAttribute("solutionGroups", solutionGroups);
        return "solution/index";
    }

    @RequestMapping("/{id}/show")
    public String show(@PathVariable("id") Long id, Model model) {
        Solution solution = solutionRepository.findOne(id);
        model.addAttribute("solution", solution);
        return "solution/show";
    }
}

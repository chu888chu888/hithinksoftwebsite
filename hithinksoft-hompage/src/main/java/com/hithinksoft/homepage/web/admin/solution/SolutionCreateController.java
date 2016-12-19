package com.hithinksoft.homepage.web.admin.solution;

import com.hithinksoft.homepage.domain.solution.SolutionGroupRepository;
import com.hithinksoft.homepage.domain.solution.SolutionRepository;
import com.hithinksoft.homepage.domain.solution.Solution;

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
 * Created by lin_xianmin on 2016-09-02.
 */
@Controller
@RequestMapping("/admin/solutions")
public class SolutionCreateController {
    @Autowired
    private SolutionRepository solutionRepository;
    @Autowired
    private SolutionGroupRepository solutionGroupRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("solution", solutionRepository.findOne(id));
        model.addAttribute("solutionGroups", solutionGroupRepository.findAll());
        return "admin/solution/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("solution", new Solution());
        model.addAttribute("solutionGroups", solutionGroupRepository.findAll());
        return "admin/solution/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute @Valid Solution solution, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("solution", solution);
            model.addAttribute("solutionGroups", solutionGroupRepository.findAll());
            return "admin/solution/create";
        }
        solutionRepository.save(solution);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SIC#index").build();
    }
}

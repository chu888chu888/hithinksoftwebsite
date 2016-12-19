package com.hithinksoft.homepage.web.admin.solution;

import com.hithinksoft.homepage.domain.solution.SolutionGroup;
import com.hithinksoft.homepage.domain.solution.SolutionGroupRepository;

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
@RequestMapping("/admin/solutionGroups")
public class SolutionGroupCreateController {
    @Autowired
    private SolutionGroupRepository solutionGroupRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("solutionGroup", solutionGroupRepository.findOne(id));
        return "admin/solutiongroup/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("solutionGroup", new SolutionGroup());
        return "admin/solutiongroup/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute @Valid SolutionGroup solutionGroup, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/solutiongroup/create";
        } else {
            solutionGroupRepository.save(solutionGroup);
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SGIC#index").build();
    }
}

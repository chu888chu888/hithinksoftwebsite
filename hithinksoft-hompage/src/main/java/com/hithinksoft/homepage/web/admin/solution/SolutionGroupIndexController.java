package com.hithinksoft.homepage.web.admin.solution;

import com.hithinksoft.homepage.domain.solution.SolutionGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

/**
 * Created by lin_xianmin on 2016-09-02.
 */
@Controller
@RequestMapping("/admin/solutionGroups")
public class SolutionGroupIndexController {
    @Autowired
    private SolutionGroupRepository solutionGroupRepository;

    @RequestMapping
    public String index(@PageableDefault(sort = "id") Pageable pageable, Model model) {
        model.addAttribute("solutionGroups", solutionGroupRepository.findAll(pageable));
        return "admin/solutiongroup/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        solutionGroupRepository.delete(id);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SGIC#index").build();
    }
}

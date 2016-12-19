package com.hithinksoft.homepage.web.admin.solution;

import com.hithinksoft.homepage.domain.solution.SolutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by lin_xianmin on 2016-09-02.
 */
@Controller
@RequestMapping("/admin/solutions")
public class SolutionIndexController {
    @Autowired
    private SolutionRepository solutionRepository;

    @RequestMapping
    public String index(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("solution", solutionRepository.findAll(pageable));
        return "admin/solution/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        solutionRepository.delete(id);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SIC#index").build();
    }
}

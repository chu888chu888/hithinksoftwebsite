package com.hithinksoft.homepage.web.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lxm on 2016/7/21.
 */
@RequestMapping("/hithinksoft")
@Controller
public class AboutHithinksoftController {
    @RequestMapping
    public String hithinksoft() {
        return "about/hithinksoft";
    }
}

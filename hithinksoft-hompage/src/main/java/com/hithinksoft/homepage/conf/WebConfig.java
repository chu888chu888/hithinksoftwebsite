package com.hithinksoft.homepage.conf;

import com.hithinksoft.homepage.view.thymeleaf.ApplicationDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

/**
 * @author snowblink on 16/5/24.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin/index");
        registry.addViewController("/admin/login").setViewName("admin/login");
    }

    @Bean
    public IDialect applicationDialect() {
        return new ApplicationDialect();
    }

    @Bean
    public IDialect springDataDialect() {
        return new SpringDataDialect();
    }
}

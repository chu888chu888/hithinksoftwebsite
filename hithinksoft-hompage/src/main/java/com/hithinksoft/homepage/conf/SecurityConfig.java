package com.hithinksoft.homepage.conf;

import com.hithinksoft.homepage.domain.permission.Permission;
import com.hithinksoft.homepage.domain.permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.List;


/**
 * @author snowblink on 16/5/24.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer = auth.jdbcAuthentication();
        configurer.dataSource(dataSource);

        if (passwordEncoder != null) {
            configurer.passwordEncoder(passwordEncoder);
        }
        configurer.getUserDetailsService().setEnableGroups(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/vendor/**", "/img/**", "/css/**", "/js/**", "**/favicon.ico", "/video/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().disable();
        http.csrf().disable();
        List<Permission> permissionList = permissionRepository.findAll();
        for (Permission permission : permissionList) {
            if (permission.isEnabled()) {
                http
                        .authorizeRequests()
                        .antMatchers(permission.getPath()).hasAuthority(permission.getAuthority());
            }
        }
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/admin/login").permitAll()
                .and()
                .logout().permitAll();
    }
}

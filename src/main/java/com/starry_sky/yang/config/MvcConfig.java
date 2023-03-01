package com.starry_sky.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 通过配置不需要为每个访问Thymeleaf模板页面单独开发一个请求了
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        /**
         * viewController 请求路径
         * viewName 跳转视图
         */
        registry.addViewController("login").setViewName("login");
        registry.addViewController("register").setViewName("regist");
        registry.addViewController("addEmp").setViewName("addEmp");
    }
}

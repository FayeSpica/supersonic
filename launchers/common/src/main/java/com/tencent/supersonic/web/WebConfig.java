package com.tencent.supersonic.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/supersonic/webapp/**").addResourceLocations("classpath:/supersonic/webapp/");

        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/supersonic/webapp/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/supersonic/webapp/");
        registry.addViewController("/supersonic/webapp/").setViewName("forward:/supersonic/webapp/index.html");
        registry.addViewController("/supersonic/webapp/**/{path:[^\\.]*}")
                .setViewName("forward:/supersonic/webapp/index.html");
    }
}

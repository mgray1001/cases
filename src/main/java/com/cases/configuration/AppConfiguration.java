package com.cases.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by mario on 10/17/14.
 */
@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter{

    @Value("${uploads.basedir}")
    String basePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**").addResourceLocations("file://"+basePath+"/*");
    }

}

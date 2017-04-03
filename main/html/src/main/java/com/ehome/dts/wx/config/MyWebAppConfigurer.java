package com.ehome.dts.wx.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	private static final Logger logger = Logger.getLogger(MyWebAppConfigurer.class);
	@Value("${system.static.dir}")
	private String staticDir;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	logger.info(staticDir);
    	registry.addResourceHandler("/dist/**").addResourceLocations(staticDir);
        super.addResourceHandlers(registry);
    }
}
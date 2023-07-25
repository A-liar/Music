package com.zyh.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: music
 * @package: com.zyh.music.config
 * @className: SingerImageConfiguration
 * @author: A_liar.
 * @date: 2023/6/30 10:54
 * @version: 1.0
 * @description: 注释
 */
@Configuration
public class SingerImageConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/singer/imageFile/**").addResourceLocations("file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+
                System.getProperty("file.separator")+"singerImage"+System.getProperty("file.separator"));
    }
}

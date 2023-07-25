package com.zyh.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: music
 * @package: com.zyh.music.config
 * @className: CorssConfiguration
 * @author: A_liar.
 * @date: 2023/6/26 18:52
 * @version: 1.0
 * @description: 跨域配置
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        addMapping 添加可跨域的请求地址
        registry.addMapping("/**")
//                设置跨域 域名权限 规定由某一个指定的域名+端口能访问跨域项目
                .allowedOriginPatterns("*")
//                规定能够跨域访问的方法类型
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
//                是否开启cookie跨域，默认关闭
                .allowCredentials(true)
//                添加验证头信息 token
//                .allowedHeaders("*")
//                预检请求存活时间，在此期间不能再次发送预检请求
                .maxAge(3600);

    }
}

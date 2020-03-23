package com.apriltechnology.achieveit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

public class CORSConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");//允许任何域名
        config.setAllowCredentials(true);//允许Cookie
        config.addAllowedMethod("*");//允许任何方法
        config.addAllowedHeader("*");//允许任何头
        config.setMaxAge(1800l);//设置预检请求保持时间，避免频繁发送预检请求

        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(configSource);
    }
}

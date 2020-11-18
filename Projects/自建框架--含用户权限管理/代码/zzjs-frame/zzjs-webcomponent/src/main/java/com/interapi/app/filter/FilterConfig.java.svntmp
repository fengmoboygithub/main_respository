package com.interapi.app.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class FilterConfig {
	@Bean(name = "authenticationTokenFilterBean")
	@Primary
    public OncePerRequestFilter authenticationTokenFilterBean() throws Exception {
        return new AbstractClientJwtFilter();
    }
}

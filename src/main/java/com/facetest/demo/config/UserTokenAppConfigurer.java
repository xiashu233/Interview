package com.facetest.demo.config;

import com.facetest.demo.Spring.UserTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class UserTokenAppConfigurer extends WebMvcConfigurationSupport {
	
	@Autowired
	private UserTokenInterceptor userTokenInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
		registry.addInterceptor(userTokenInterceptor).addPathPatterns("/**")
		.excludePathPatterns("/account/login","/account/register");		
		super.addInterceptors(registry);
	}
}

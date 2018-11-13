package com.ckdpharm.homepage;

import com.ckdpharm.homepage.common.config.AppConfig;
import com.ckdpharm.homepage.interceptor.ViewInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerInterceptor;
import org.springframework.mobile.device.switcher.SiteSwitcherHandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(
        basePackages = {
                "com.ckdpharm"
        })
@EnableAspectJAutoProxy
public class WebMvcConfig extends AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/pc/");
        registry.addResourceHandler("/m/assets/**").addResourceLocations("classpath:/assets/mobile/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceResolverHandlerInterceptor())
                .order(0);
        registry.addInterceptor(sitePreferenceHandlerInterceptor())
                .order(1);
        registry.addInterceptor(siteSwitcherHandlerInterceptor())
                .order(2);
        registry.addInterceptor(viewInterceptor())
                .order(3);
    }

    @Bean
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor();
    }

    @Bean
    public SitePreferenceHandlerInterceptor sitePreferenceHandlerInterceptor() {
        return new SitePreferenceHandlerInterceptor();
    }

    @Bean
    public SiteSwitcherHandlerInterceptor siteSwitcherHandlerInterceptor() {
        return SiteSwitcherHandlerInterceptor.urlPath("/m", "/m", "/");
    }

    @Bean
    public ViewInterceptor viewInterceptor() {
        return new ViewInterceptor();
    }
}

package com.ckdpharm.homepage.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String devicePath = request.getRequestURI().startsWith("/m/") ? "mobile" : "pc";
        modelAndView.setViewName(devicePath + "/modules/views/" + modelAndView.getViewName());
        super.postHandle(request, response, handler, modelAndView);
    }
}

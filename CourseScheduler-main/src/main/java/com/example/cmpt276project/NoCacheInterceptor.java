package com.example.cmpt276project;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class NoCacheInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // Disable caching for all browsers
        response.setHeader("Cache-Control", "private, no-cache, no-store, must-revalidate");
        response.setHeader("Expires", "-1");
        response.setHeader("Pragma", "no-cache");
    }
}
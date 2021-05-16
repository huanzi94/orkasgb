//package com.orkasgb.orkasgbserver.handlerInterceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//@Configuration
//@ControllerAdvice
//public class ResponseInterceptor implements WebMvcConfigurer, ResponseBodyAdvice {
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class aClass) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest request, ServerHttpResponse response) {
//        return null;
//    }
//}

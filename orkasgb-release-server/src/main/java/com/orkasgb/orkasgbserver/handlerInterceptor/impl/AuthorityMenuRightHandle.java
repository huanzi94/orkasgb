package com.orkasgb.orkasgbserver.handlerInterceptor.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityMenuRight;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order
@Component
public class AuthorityMenuRightHandle {

    @Around("@within(com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityMenuRight)")
    public Object AuthorityMenuRight(ProceedingJoinPoint point) throws Throwable {
        AuthorityMenuRight authorityMenuRight = AnnotationUtils.findAnnotation(point.getSignature().getDeclaringType(), AuthorityMenuRight.class);
        String url = authorityMenuRight.url();
        // 当前账号是否含有访问的菜单权限
        StpUtil.checkPermission(url);
        Object obj = point.proceed();
        return obj;
    }
}

package com.orkasgb.orkasgbserver.handlerInterceptor.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.orkasgb.orkasgbapp.commcode.commenum.RolesEnum;
import com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityAuthentication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order
@Component
public class AuthorityAuthenticationHandle {

    @Around("@annotation(com.orkasgb.orkasgbserver.handlerInterceptor.AuthorityAuthentication)")
    public Object AuthorityAuthentication(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        // 获取自定义注解
        AuthorityAuthentication annotation = AnnotationUtils.findAnnotation(methodSignature.getMethod(), AuthorityAuthentication.class);
        RolesEnum rolesEnum = annotation.roles();
        // 当前账号是否含有访问的角色权限
        StpUtil.checkRole(RolesEnum.getCodeByValue(rolesEnum.name()));
        Object obj = point.proceed();

        return obj;
    }
}

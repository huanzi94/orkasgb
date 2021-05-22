package com.orkasgb.orkasgbserver.handlerInterceptor.commons;

import cn.dev33.satoken.stp.StpUtil;
import com.orkasgb.orkasgbapp.commcode.CodeEnum;
import com.orkasgb.orkasgbapp.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

@Aspect
@Order
@Component
public class RequestTranscodingHandler {

//    @Resource
//    LogServer logServer;

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        ResultVo resultVo = new ResultVo<>(CodeEnum.FAIL.getStatus(), CodeEnum.FAIL.getCode());
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        String requestURI = request.getRequestURI();
        if (!StringUtils.containsIgnoreCase(requestURI, "login/loginValidate")
                && !StringUtils.containsIgnoreCase(requestURI, "login/loginOut")) {
            StpUtil.checkLogin();
        }
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        // 方法
        String method = methodSignature.getMethod().getName();
        // 目标类
        String objectClass = point.getTarget().getClass().getName();
        // 方法执行需要的参数
        Map<String, Object> params = request.getParameterMap();
//            LogEntity logEntity = new LogEntity();
//            logEntity.setOperator("admin1");
//            logEntity.setOperationTime(DateUtils.current24TimeString());
//            logEntity.setClassName(objectClass);
//            logEntity.setMethod(method);
//            logEntity.setArguments(JSON.toJSONString(params));
//            logEntity.setResults(object);
//            logServer.save(logEntity);
        return point.proceed();
    }
}

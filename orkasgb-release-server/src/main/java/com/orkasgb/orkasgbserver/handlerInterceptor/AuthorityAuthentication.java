package com.orkasgb.orkasgbserver.handlerInterceptor;

import com.orkasgb.orkasgbapp.commcode.commenum.OperationsEnum;
import com.orkasgb.orkasgbapp.commcode.commenum.RolesEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorityAuthentication {
    OperationsEnum operation() default OperationsEnum.ALL;

    RolesEnum roles() default RolesEnum.ALL;
}

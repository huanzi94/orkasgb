package com.orkasgb.orkasgbweb.controller;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

public class BaseController {

    @Resource
    HttpServletResponse response;

    @Resource
    HttpServletRequest request;


    public String getParameter(String strName) {
        String param = request.getParameter(strName);
        if (StringUtils.isNotBlank(param)) {
            param = param.trim();
        }
        return param;
    }

    public String getParameterOrDefault(String strName, String defaultString) {
        String param = request.getParameter(strName);
        if (StringUtils.isBlank(param)) {
            param = defaultString;
        }
        return param.trim();
    }

    public Integer getPagingNumOrDefault(String pageNum) {
        String pageNo = request.getParameter(pageNum);
        if (StringUtils.isBlank(pageNo)) {
            pageNo = BigInteger.ZERO.toString();
        }
        return Integer.valueOf(pageNo.trim());
    }

    public Integer getPagingSizeOrDefault(String pageSize) {
        String pageSizes = request.getParameter(pageSize);
        if (StringUtils.isBlank(pageSizes)) {
            pageSizes = BigInteger.valueOf(100L).toString();
        }
        return Integer.valueOf(pageSizes.trim());
    }

    public HttpServletRequest getRequest() {
        return this.request;
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }
}

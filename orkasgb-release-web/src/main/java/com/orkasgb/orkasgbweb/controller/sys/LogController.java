//package com.orkasgb.orkasgbweb.controller.sys;
//
//import com.alibaba.fastjson.JSON;
//import com.orkasgb.orkasgbapp.commcode.CodeEnum;
//import com.orkasgb.orkasgbapp.vo.ResultVo;
//import com.orkasgb.orkasgbserver.elasticsearch.LogServer;
//import com.orkasgb.orkasgbserver.elasticsearch.LogEntity;
//import com.orkasgb.orkasgbweb.controller.BaseController;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//
//@Controller
//@CrossOrigin
//@ResponseBody
//@RequestMapping(value = "/log")
//public class LogController extends BaseController {
//
//    @Resource
//    LogServer logServer;
//
//    @RequestMapping(value = "/getLogInfo", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVo getLogInfo () {
//        ResultVo resultVo = new ResultVo<>(CodeEnum.SUCCESS.getStatus(), CodeEnum.SUCCESS.getCode());
//
//        Pageable page = PageRequest.of(this.getPagingNumOrDefault("pageNo"), this.getPagingSizeOrDefault("pageSize"));
//        LogEntity logEntity = new LogEntity();
//        logEntity.setStartOperationTime(this.getParameter("operationTime[0]"));
//        logEntity.setEndOperationTime(this.getParameter("operationTime[1]"));
//        logEntity.setOperator(this.getParameter("operator"));
//        logEntity.setResults(this.getParameter("results"));
//        Page<LogEntity> logEntries = logServer.getLogInfo(logEntity, page);
//        resultVo.setData(logEntries);
//        return resultVo;
//    }
//}

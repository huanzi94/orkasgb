//package com.orkasgb.orkasgbserver.elasticsearch;
//
//import org.apache.commons.lang3.StringUtils;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.index.query.RangeQueryBuilder;
//import org.elasticsearch.index.query.TermQueryBuilder;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.Objects;
//
//@Service
//public class LogServer {
//
//    @Resource
//    LogRepository repository;
//
//    public LogEntity save (LogEntity logEntity) {
//        return repository.save(logEntity);
//    }
//
//    public Page<LogEntity> getLogInfo(LogEntity logEntity, Pageable pageable) {
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        TermQueryBuilder operatorQuery = null;
//        if (StringUtils.isNotBlank(logEntity.getOperator())) {
//            operatorQuery = QueryBuilders.termQuery("operator", logEntity.getOperator());
//            queryBuilder.must(operatorQuery);
//        }
//        TermQueryBuilder requestQuery= null;
//        if (Objects.nonNull(logEntity.getResults())) {
//            requestQuery = QueryBuilders.termQuery("results", logEntity.getResults());
//            queryBuilder.should(requestQuery);
//        }
//        RangeQueryBuilder timeQuery= null;
//        if (StringUtils.isNotBlank(logEntity.getStartOperationTime()) && StringUtils.isNotBlank(logEntity.getEndOperationTime())) {
//            timeQuery = QueryBuilders.rangeQuery("operationTime").from(logEntity.getStartOperationTime()).to(logEntity.getEndOperationTime());
//            queryBuilder.must(timeQuery);
//        }
//        return repository.search(queryBuilder, pageable);
//    }
//}

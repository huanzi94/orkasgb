//package com.orkasgb.orkasgbserver.elasticsearch;
//
//import org.elasticsearch.index.query.QueryBuilder;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface CommonEsRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
//
//    List<T> findByOperator (String operator);
//
//    List<T> findByOperationTimeBetween (String startTime, String endTime);
//
//    Page<LogEntity> search(QueryBuilder queryBuilder, Pageable pageable);
//
//}

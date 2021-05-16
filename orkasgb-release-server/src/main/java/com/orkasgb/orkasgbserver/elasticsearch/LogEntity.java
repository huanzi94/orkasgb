//package com.orkasgb.orkasgbserver.elasticsearch;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.io.Serializable;
//
//@Data
//@Document(indexName = "log", shards = 3, replicas = 0)
//public class LogEntity implements Serializable {
//
//    @Id
//    private String id;
//
//    @Field(type = FieldType.Keyword)
//    private String operator;
//
//    @Field(type = FieldType.Keyword)
//    private String className;
//
//    @Field(type = FieldType.Keyword)
//    private String method;
//
//    @Field(type = FieldType.Keyword)
//    private String arguments;
//
//    @Field(type = FieldType.Keyword)
//    private String operationTime;
//
//    @Field(type = FieldType.Text)
//    private Object results;
//
//    private String startOperationTime;
//
//    private String endOperationTime;
//}

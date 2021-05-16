//package com.orkasgb.orkasgbapp.elasticsearch;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//public class ElasticsearchService {
//
//    @Autowired
//    RestHighLevelClient client;
//
//    public void saveData (String index, JSONObject jsonObject) throws IOException {
//        IndexRequest request = new IndexRequest(index);
//        request.source(JSON.toJSONString(jsonObject), XContentType.JSON);
//        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
//    }
//}

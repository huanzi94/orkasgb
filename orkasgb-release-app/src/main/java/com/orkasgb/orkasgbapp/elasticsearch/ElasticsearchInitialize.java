//package com.orkasgb.orkasgbapp.elasticsearch;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import lombok.NonNull;
//import org.apache.http.HttpHost;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.client.indices.CreateIndexRequest;
//import org.elasticsearch.client.indices.CreateIndexResponse;
//import org.elasticsearch.client.indices.GetIndexRequest;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class ElasticsearchInitialize {
//
//    private String esClusterName = "orkasgb_es1";
//
//    private String schema = "http";
//
//    private int esPort = 9200;
//
//    private String esHost = "172.16.5.129";
//
//    private RestHighLevelClient client;
//
//    private HttpHost httpHost;
//
//    @Bean
//    public RestHighLevelClient initialClient() {
//        httpHost = new HttpHost(esHost, esPort, schema);
//        if (client == null){
//            synchronized (ElasticsearchInitialize.class) {
//                if(client == null) {
//                    client = new RestHighLevelClient(RestClient.builder(httpHost));
//                }
//            }
//        }
//        try {
//            initialIndex("demo_index");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return client;
//    }
//
//    public boolean initialIndex(String index) throws Exception {
//        if (indexIsExists(index)) {
//            return true;
//        }
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
//        createIndexRequest.settings(Settings.builder()
//                .put("index.number_of_shards", "3")
//                .put("index.number_of_replicas", "2")
//                .build());// 分片数 副本数
//        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
//        boolean isAcknowledged = createIndexResponse.isAcknowledged();
//        return isAcknowledged;
//    }
//
//    public boolean indexIsExists (@NonNull String index) throws Exception{
//        GetIndexRequest getIndexRequest = new GetIndexRequest(index);
//        getIndexRequest.local(false);
//        getIndexRequest.humanReadable(true);
//        boolean isExists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
//        return isExists;
//    }
//
//
//    /**
//     * 关闭连接
//     */
//    public void close() throws IOException {
//        if (client != null) {
//            client.close();
//        }
//    }
//
//}
//

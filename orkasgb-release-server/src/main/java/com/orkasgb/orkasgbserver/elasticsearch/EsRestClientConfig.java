//package com.orkasgb.orkasgbserver.elasticsearch;
//
//
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EsRestClientConfig extends AbstractElasticsearchConfiguration {
//
//    // private String[] server = {"192.168.43.171:9200", "192.168.43.94:9200", "192.168.43.39:9200"};
//    private String[] server = {"127.0.0.1"};
//
//    @Bean
//    @Override
//    public RestHighLevelClient elasticsearchClient() {
//        /*HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth(userName, password);*/
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(server).build();
//        return RestClients.create(clientConfiguration).rest();
//    }
//}

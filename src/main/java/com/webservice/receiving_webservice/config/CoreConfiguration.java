package com.webservice.receiving_webservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class CoreConfiguration {

    @Bean
    public RestTemplate restTemplate(){
            return new RestTemplate();
}


    @Value("${.api.endpoint.prod}")
    private String informationApiEndpoint;
//    @Value("${.app.key}")
//    private String informationAppKey;
//    @Value("${.app.token}")
//    private String informationToken;
}

package com.webservice.receiving_webservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class ClientSending {

    private final RestTemplate restTemplate;

    @Value("${.api.endpoint.prod}")
    private String informationApiEndpoint;
    @Value("${.app.key}")
    private String informationAppKey;
    @Value("${.app.token}")
    private String informationToken;


    public ReceivingDto getInformations(){
        URI url = UriComponentsBuilder.fromHttpUrl(informationApiEndpoint)
                .queryParam("key", informationAppKey)
                .queryParam("token", informationToken)
                .queryParam("fields", "name,id")
//                .queryParam("lists", "all")
//                .queryParam("", informationAppKey)
//                .queryParam("", informationToken)
                .build()
                .encode()
                .toUri();

        ReceivingDto informationBoard = restTemplate.getForObject(url, ReceivingDto.class);

        return informationBoard;

    }
}
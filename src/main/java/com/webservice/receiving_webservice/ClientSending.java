package com.webservice.receiving_webservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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


    public DataTransferDto getInformation(){
        URI url = UriComponentsBuilder.fromHttpUrl(informationApiEndpoint)
                .queryParam("", informationAppKey)
                .queryParam("", informationToken)
                .build()
                .encode()
                .toUri();
        DataTransferDto information = restTemplate.getForObject(url, DataTransferDto.class);

        return information;

    }
}
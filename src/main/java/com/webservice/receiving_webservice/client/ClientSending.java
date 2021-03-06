package com.webservice.receiving_webservice.client;

import com.webservice.receiving_webservice.config.CoreConfiguration;
import com.webservice.receiving_webservice.domain.ReceivingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class ClientSending {


    private final RestTemplate restTemplate;


    private final CoreConfiguration coreConfiguration;


    public ReceivingDto getReceivingDto(){
        URI url = UriComponentsBuilder.fromHttpUrl(coreConfiguration.getInformationApiEndpoint())
//                .queryParam("key", informationAppKey)
//                .queryParam("token", informationToken)
                .build()
                .encode()
                .toUri();

        return restTemplate.getForObject(url, ReceivingDto.class);
    }

}
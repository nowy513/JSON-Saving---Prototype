package com.webservice.receiving_webservice;

import com.webservice.receiving_webservice.client.ClientSending;
import com.webservice.receiving_webservice.config.CoreConfiguration;
import com.webservice.receiving_webservice.domain.ReceivingDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientTest {

    @InjectMocks
    private ClientSending clientSending;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CoreConfiguration coreConfiguration;

    @Test
    public void shouldFetchReceivingDto() throws URISyntaxException{

//        Given
        when(coreConfiguration.getInformationApiEndpoint()).thenReturn("http://test.com");

        ReceivingDto receivingDto = new ReceivingDto(
                1L, "Test"
        );

        URI uri = new URI("http://test.com");

        when(restTemplate.getForObject(uri, ReceivingDto.class)).thenReturn(receivingDto);

//        When
        ReceivingDto fetchedReceivingDto = clientSending.getReceivingDto();

//        Then
        assertEquals(1, fetchedReceivingDto.getId());
        assertEquals("Test", fetchedReceivingDto.getInformation());
    }
}

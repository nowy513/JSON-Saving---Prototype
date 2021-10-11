package com.webservice.receiving_webservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTransferDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("information")
    private String information;


}

package com.webservice.receiving_webservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceivingDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("information")
    private String information;

}

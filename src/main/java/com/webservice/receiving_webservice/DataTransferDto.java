package com.webservice.receiving_webservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTransferDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;


}

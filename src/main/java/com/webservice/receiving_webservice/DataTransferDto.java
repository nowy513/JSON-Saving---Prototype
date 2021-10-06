package com.webservice.receiving_webservice;

import lombok.*;

import javax.persistence.Entity;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataTransferDto {

    private Long id;
    private String information;

}

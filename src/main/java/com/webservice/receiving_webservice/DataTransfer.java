package com.webservice.receiving_webservice;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "DATA_TRANSFER")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataTransfer {

    @Id
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Column(name = "INFORMATION")
    private String information;
}

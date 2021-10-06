package com.webservice.receiving_webservice;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DATA_TRANSFER")
public class DataTransfer {

    @Id
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Column(name = "INFORMATION")
    private String information;
}

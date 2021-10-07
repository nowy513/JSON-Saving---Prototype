package com.webservice.receiving_webservice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataTransferMapper {


//    public DataTransfer mapToTransfer(final DataTransferDto dataTransferDto){
//        return new DataTransfer(
//                dataTransferDto.getId(),
//                dataTransferDto.getName()
//        );
//    }

    public DataTransferDto mapToTransferDto(final DataTransfer dataTransfer){
        return new DataTransferDto(
                dataTransfer.getId(),
                dataTransfer.getName()
        );
    }

    public List<DataTransferDto> mapToTransferListDto(final List<DataTransfer> transfers){
        return transfers.stream()
                .map(this::mapToTransferDto)
                .collect(Collectors.toList());
    }

    public DataTransfer mapToDataTransfer(final ReceivingDto receivingDto){
        return new DataTransfer(
                receivingDto.getId(),
                receivingDto.getName()
        );
    }
}

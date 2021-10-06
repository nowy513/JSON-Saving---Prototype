package com.webservice.receiving_webservice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DataTransferMapper {

    private ClientSending clientSending;

    public DataTransfer mapToTransfer(final DataTransferDto dataTransferDto){
        return new DataTransfer(
                dataTransferDto.getId(),
                dataTransferDto.getInformation()
        );
    }

    public DataTransferDto mapToTransferDto(final DataTransfer dataTransfer){
        return new DataTransferDto(
                clientSending.getInformation().getId(),
                clientSending.getInformation().getInformation()
        );
    }

    public List<DataTransferDto> mapToTransferListDto(final List<DataTransfer> transfers){
        return transfers.stream()
                .map(this::mapToTransferDto)
                .collect(Collectors.toList());
    }
}

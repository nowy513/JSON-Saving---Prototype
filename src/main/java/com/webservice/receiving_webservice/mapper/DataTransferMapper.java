package com.webservice.receiving_webservice.mapper;

import com.webservice.receiving_webservice.client.ClientSending;
import com.webservice.receiving_webservice.domain.DataTransfer;
import com.webservice.receiving_webservice.domain.DataTransferDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataTransferMapper {

    public DataTransfer mapToTransfer(final DataTransferDto dataTransferDto){
        return new DataTransfer(
                dataTransferDto.getId(),
                dataTransferDto.getInformation()
        );
    }

    public DataTransferDto mapToTransferDto(final DataTransfer dataTransfer){
        return new DataTransferDto(
                dataTransfer.getId(),
                dataTransfer.getInformation()
        );
    }

    public List<DataTransferDto> mapToTransferListDto(final List<DataTransfer> transfers){
        return transfers.stream()
                .map(this::mapToTransferDto)
                .collect(Collectors.toList());
    }

    public DataTransfer mapToDataTransfer(ClientSending clientSending){
        return new DataTransfer(
                clientSending.getReceivingDto().getId(),
                clientSending.getReceivingDto().getInformation()
        );
    }
}

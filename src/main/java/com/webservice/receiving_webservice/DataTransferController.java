package com.webservice.receiving_webservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class DataTransferController {

    @Autowired
    private DataTransferService dataTransferService;

    @Autowired
    private DataTransferMapper dataTransferMapper;

    private final ClientSending clientSending;


    @GetMapping("/all")
    public List<DataTransferDto> getDataBase(){
        return dataTransferMapper.mapToTransferListDto(dataTransferService.getAllTransfers());
    }

    @GetMapping
    public DataTransfer getSaveInformation(@RequestBody ReceivingDto receivingDto){
        return dataTransferService.saveTransfer(dataTransferMapper.mapToDataTransfer(receivingDto));
    }

//    @GetMapping("/{id}")
//    public DataTransferDto getInformation(@PathVariable Long id) throws Exception{
//        return dataTransferMapper.mapToTransferDto(dataTransferService.getTransfer(id).orElseThrow(Exception::new));
//    }

    @GetMapping("/ReceivedInformation")
    public ReceivingDto getReceivedInformation(){
        return clientSending.getInformations();
    }


    @DeleteMapping
    public void deteleInformation(){
        dataTransferService.deleteTransfer();
    }
}

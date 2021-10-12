package com.webservice.receiving_webservice.controller;

import com.webservice.receiving_webservice.client.ClientSending;
import com.webservice.receiving_webservice.domain.DataTransfer;
import com.webservice.receiving_webservice.domain.DataTransferDto;
import com.webservice.receiving_webservice.domain.ReceivingDto;
import com.webservice.receiving_webservice.mapper.DataTransferMapper;
import com.webservice.receiving_webservice.service.DataTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@RestController
public class DataTransferController {

    @Autowired
    private DataTransferService dataTransferService;

    @Autowired
    private DataTransferMapper dataTransferMapper;

    @Autowired
    private ClientSending clientSending;



    @GetMapping("/allDatabase")
    public List<DataTransferDto> getDatabase(){
        return dataTransferMapper.mapToTransferListDto(dataTransferService.getAllDatabase());
    }

    @GetMapping("/saveInformation")
    public DataTransfer savingTheInformationSent(){
        return dataTransferService.saveInformation(dataTransferMapper.mapToDataTransfer(clientSending));
    }

    @GetMapping("/receivedInformation")
    public ReceivingDto getReceivedInformation(){
        return clientSending.getReceivingDto();
    }

    @GetMapping("/{id}")
    public DataTransferDto lookingForInformationInTheDataBase(@PathVariable Long id) throws Exception{
        return dataTransferMapper.mapToTransferDto(dataTransferService.getTransfer(id).orElseThrow(Exception::new));
    }

    @PostMapping("/createInformation")
    public DataTransfer saveTheCreatingInformation(@RequestBody DataTransferDto dataTransferDto){
        return dataTransferService.saveInformation(dataTransferMapper.mapToTransfer(dataTransferDto));
    }

    @DeleteMapping("/{id}")
    public void deteleInformationInTheDatabase(@PathVariable Long id){
        dataTransferService.deleteInformation(id);
    }


    @DeleteMapping("/clearingTheDatabase")
    public void clearingTheDatabase(){
        dataTransferService.clearingTheDatabase();
    }

}

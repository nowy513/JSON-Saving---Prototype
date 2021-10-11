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


    @GetMapping("/allDatabase")
    public List<DataTransferDto> getDatabase(){
        return dataTransferMapper.mapToTransferListDto(dataTransferService.getAllDatabase());
    }

    @GetMapping("/saveInformation")
    public DataTransfer savingTheInformationSent(@RequestBody ReceivingDto receivingDto){
        return dataTransferService.saveInformation(dataTransferMapper.mapToDataTransfer(receivingDto));
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

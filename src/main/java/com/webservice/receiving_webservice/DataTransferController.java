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
    public List<DataTransferDto> getInformation(){
        return dataTransferMapper.mapToTransferListDto(dataTransferService.getAllTransfers());
    }

    @GetMapping("/{id}")
    public DataTransferDto getInformation(@PathVariable Long id) throws Exception{
        return dataTransferMapper.mapToTransferDto(dataTransferService.getTransfer(id).orElseThrow(Exception::new));
    }

    @PostMapping("/create")
    public DataTransfer createInformation(@RequestBody ReceivingDto reveivingDto){
        return dataTransferService.saveTransfer(dataTransferMapper.mapToDataTransfer(reveivingDto));
    }

    @GetMapping
    public ReceivingDto getInformationsBoard(){
        ReceivingDto receiving = clientSending.getInformations();
        return receiving;
    }

    @DeleteMapping
    public void deteleInformation(){
        dataTransferService.deleteTransfer();
    }
}

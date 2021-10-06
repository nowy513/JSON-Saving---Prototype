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


    @GetMapping("/all")
    public List<DataTransferDto> getInformation(){
        return dataTransferMapper.mapToTransferListDto(dataTransferService.getAllTransfers());
    }

    @GetMapping("/{id}")
    public DataTransferDto getInformation(@PathVariable Long id) throws Exception{
        return dataTransferMapper.mapToTransferDto(dataTransferService.getTransfer(id).orElseThrow(Exception::new));
    }

    @PostMapping("/create")
    public DataTransferDto createInformation(@RequestBody DataTransferDto dataTransferDto){
        return dataTransferMapper.mapToTransferDto(dataTransferService.saveTransfer(dataTransferMapper.mapToTransfer(dataTransferDto)));
    }

    @DeleteMapping("/{id}")
    public void deteleInformation(@PathVariable Long id){
        dataTransferService.deleteTransfer(id);
    }
}

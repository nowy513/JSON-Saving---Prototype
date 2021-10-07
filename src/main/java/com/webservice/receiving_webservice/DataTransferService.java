package com.webservice.receiving_webservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DataTransferService {

    private DataTransferRepository dataTransferRepository;

    public List<DataTransfer> getAllTransfers(){
        return dataTransferRepository.findAll();
    }

    public Optional<DataTransfer> getTransfer(final Long id){
        return dataTransferRepository.findById(id);
    }

    public DataTransfer saveTransfer(final DataTransfer dataTransfer){
        return dataTransferRepository.save(dataTransfer);
    }

    public void deleteTransfer(){
        dataTransferRepository.deleteAll();
    }
}

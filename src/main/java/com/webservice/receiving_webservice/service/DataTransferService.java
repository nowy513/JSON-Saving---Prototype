package com.webservice.receiving_webservice.service;

import com.webservice.receiving_webservice.repository.DataTransferRepository;
import com.webservice.receiving_webservice.domain.DataTransfer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DataTransferService {

    private final DataTransferRepository dataTransferRepository;

    public List<DataTransfer> getAllDatabase(){
        return dataTransferRepository.findAll();
    }

    public Optional<DataTransfer> getTransfer(final Long id){
        return dataTransferRepository.findById(id);
    }

    public DataTransfer saveInformation(final DataTransfer dataTransfer){
        return dataTransferRepository.save(dataTransfer);
    }

    public void deleteInformation(Long id){
        dataTransferRepository.deleteById(id);
    }

    public void clearingTheDatabase(){
        dataTransferRepository.deleteAll();
    }
}

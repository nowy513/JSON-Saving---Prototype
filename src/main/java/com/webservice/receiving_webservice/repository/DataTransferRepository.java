package com.webservice.receiving_webservice.repository;

import com.webservice.receiving_webservice.domain.DataTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTransferRepository extends JpaRepository<DataTransfer, Long> {
}

//package com.webservice.receiving_webservice;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class DataTransferServiceTest {
//
//    @InjectMocks
//    DataTransferService dataTransferService;
//
//    @Mock
//    DataTransferRepository dataTransferRepository;
//
//
//    @Test
//    public void testGetAllTransfers() {
//
////        Given
//        DataTransfer dataTransfer = new DataTransfer(
//                1L, "Information"
//        );
//        List<DataTransfer> dataTransferList = new ArrayList<>();
//        dataTransferList.add(dataTransfer);
//
//        when(dataTransferRepository.findAll()).thenReturn(dataTransferList);
//
////        When
//        List<DataTransfer> dataTransfers = dataTransferService.getAllTransfers();
//
////        Then
//        assertEquals(1,dataTransfers.size());
//    }
//
//    @Test
//    public void testGetTransfer() {
//
////        Given
//        DataTransfer dataTransfer = new DataTransfer(
//                1L, "Information"
//        );
//        List<DataTransfer> dataTransferList = new ArrayList<>();
//        dataTransferList.add(dataTransfer);
//
//        when(dataTransferRepository.findById(1L)).thenReturn(Optional.of(dataTransfer));
//
////        When
//        Optional<DataTransfer> getTest = dataTransferService.getTransfer(1L);
//
////        Then
//        assertEquals(Optional.of(dataTransfer),getTest);
//
//    }
//
////    @Test
////    public void testSaveTransfer() {
////
//////        Given
////        DataTransfer dataTransfer = new DataTransfer(
////                1L, "Information"
////        );
////
////        when(dataTransferRepository.save(dataTransfer)).thenReturn(dataTransfer);
////
//////        When
////        DataTransfer saveTest = dataTransferService.saveTransfer(dataTransfer);
////
//////        Then
////        assertEquals("Information", saveTest.getInformation());
////    }
//
//    @Test
//    public void testDeleteTransfer() {
//
////        Given
//        DataTransfer dataTransfer = new DataTransfer(
//                1L, "Information"
//        );
//
//        Long id = dataTransfer.getId();
//        dataTransferService.deleteTransfer(id);
//
////        When
//      Optional<DataTransfer> deleteTest = dataTransferService.getTransfer(1L);
//
////        Then
//        assertFalse(deleteTest.isPresent());
//
//
//    }
//}
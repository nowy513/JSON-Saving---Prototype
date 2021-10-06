package com.webservice.receiving_webservice;

import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(DataTransferController.class)
public class DataTransferControllerTest {

    @MockBean
    DataTransferMapper dataTransferMapper;

    @MockBean
    DataTransferService dataTransferService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldFetchEmptyList() throws Exception {

//        Given
        List<DataTransferDto> dataTransferDtoList = new ArrayList<>();

        when(dataTransferMapper.mapToTransferListDto(dataTransferService.getAllTransfers())).thenReturn(dataTransferDtoList);

//        When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                .get("/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void shouldGetAllTransfers() throws Exception {

//        Given
        List<DataTransfer> dataTransferList = new ArrayList<>();
        when(dataTransferService.getAllTransfers()).thenReturn(dataTransferList);

//        When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                .get("/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    public void shouldGetTransfer() throws Exception {

//        Given
        DataTransfer dataTransfer = new DataTransfer(
                1L, "information"
        );
        DataTransferDto dataTransferDto = new DataTransferDto(
                1L, "information"
        );

        when(dataTransferService.getTransfer(1L)).thenReturn(Optional.of(dataTransfer));
        when(dataTransferMapper.mapToTransferDto(any())).thenReturn(dataTransferDto);

//        When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                .get("/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.information", Matchers.is("information")))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    public void shouldCreateDataTransfer() throws Exception {

//        Given
        DataTransfer dataTransfer = new DataTransfer(
                1L, " Information"
        );
        DataTransferDto dataTransferDto = new DataTransferDto(
                1L, "information"
        );

        when(dataTransferService.saveTransfer(any(DataTransfer.class))).thenReturn(new DataTransfer(1L, "Information"));

        Gson gson = new Gson();
        String jsonContent = gson.toJson(dataTransferDto);

//        When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                .post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void shouldDeleteDataTransfer() throws Exception {

//        Given
        DataTransfer dataTransfer = new DataTransfer(
                1L, "Information"
        );

        when(dataTransferService.saveTransfer(dataTransfer)).thenReturn(dataTransfer);

//        When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                .delete("/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }


}

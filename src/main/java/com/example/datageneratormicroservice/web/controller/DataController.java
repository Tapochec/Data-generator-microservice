package com.example.datageneratormicroservice.web.controller;

import com.example.datageneratormicroservice.model.Data;
import com.example.datageneratormicroservice.model.Test.DataTestOptions;
import com.example.datageneratormicroservice.service.KafkaDataService;
import com.example.datageneratormicroservice.service.TestDataService;
import com.example.datageneratormicroservice.web.DTO.DataDto;
import com.example.datageneratormicroservice.web.DTO.DataTestOptionsDto;
import com.example.datageneratormicroservice.web.mapper.DataMapper;
import com.example.datageneratormicroservice.web.mapper.DataTestOptionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
public class DataController {

    @Autowired
    private final DataMapper dataMapper;
    @Autowired
    private final DataTestOptionsMapper dataTestOptionsMapper;

    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;

    @Autowired
    public DataController(DataMapper dataMapper, DataTestOptionsMapper dataTestOptionsMapper,
                          KafkaDataService kafkaDataService, TestDataService testDataService) {
        this.dataMapper = dataMapper;
        this.dataTestOptionsMapper = dataTestOptionsMapper;
        this.kafkaDataService = kafkaDataService;
        this.testDataService = testDataService;
    }

    @PostMapping("/send")
    public void send(@RequestBody DataDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("DataDto must not be null");
        }

        Data data = dataMapper.toEntity(dto);
        if (data.getMeasurementType() == null) {
            throw new IllegalArgumentException("MeasurementType must not be null");
        }

        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }

}

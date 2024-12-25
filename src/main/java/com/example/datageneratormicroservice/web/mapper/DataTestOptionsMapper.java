package com.example.datageneratormicroservice.web.mapper;

import com.example.datageneratormicroservice.model.Data;
import com.example.datageneratormicroservice.model.Test.DataTestOptions;
import com.example.datageneratormicroservice.web.DTO.DataDto;
import com.example.datageneratormicroservice.web.DTO.DataTestOptionsDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DataTestOptionsMapper implements Mappable<DataTestOptions, DataTestOptionsDto> {
    @Override
    public DataTestOptions toEntity(DataTestOptionsDto dto) {
        if (dto == null) {
            return null;
        }
        DataTestOptions entity = new DataTestOptions();
        // Преобразование полей из DataTestOptionsDto в DataTestOptions
        return entity;
    }

    @Override
    public DataTestOptionsDto toDto(DataTestOptions entity) {
        if (entity == null) {
            return null;
        }
        DataTestOptionsDto dto = new DataTestOptionsDto();
        // Преобразование полей из DataTestOptions в DataTestOptionsDto
        return dto;
    }
}

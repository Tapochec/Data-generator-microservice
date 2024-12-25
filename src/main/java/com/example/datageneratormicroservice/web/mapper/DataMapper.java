package com.example.datageneratormicroservice.web.mapper;

import com.example.datageneratormicroservice.model.Data;
import com.example.datageneratormicroservice.web.DTO.DataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
public class DataMapper implements Mappable<Data, DataDto> {
    @Override

    public Data toEntity(DataDto dto) {
        Data data = new Data();
        data.setSensorId(dto.getSensorId());
        data.setTimestamp(dto.getTimestamp());
        data.setMeasurement(dto.getMeasurement());

        if (dto.getMeasurementType() != null) {
            data.setMeasurementType(Data.MeasurementType.valueOf(dto.getMeasurementType().toString()));
        } else {
            throw new IllegalArgumentException("MeasurementType in DataDto must not be null");
        }

        return data;
    }

    @Override
    public DataDto toDto(Data entity) {
        DataDto dto = new DataDto();
        // Преобразование полей из Data в DataDto
        return dto;
    }
}

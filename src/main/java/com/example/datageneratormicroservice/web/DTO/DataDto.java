package com.example.datageneratormicroservice.web.DTO;

import com.example.datageneratormicroservice.model.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class DataDto {

    private Long sensorId;

    @JsonFormat (pattern = "yyyy-MM-dd'T'HH:mm:ss")

    private LocalDateTime timestamp;
    private double measurement;
    private Data.MeasurementType measurementType;

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }

    public Data.MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(Data.MeasurementType measurementType) {
        this.measurementType = measurementType;
    }




}

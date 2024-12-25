package com.example.datageneratormicroservice.model;



import java.time.LocalDateTime;


public class Data {

    public enum MeasurementType {
        TEMPERATURE,
        VOLTAGE,
        POWER
    }

    private Long sensorId;
    private LocalDateTime timestamp; //время отправления
    private double measurement; //значение, которое прислал датчик

    private MeasurementType measurementType;

    public Data() {
    }

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


    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }



}

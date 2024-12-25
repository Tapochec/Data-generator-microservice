package com.example.datageneratormicroservice.model.Test;

import com.example.datageneratormicroservice.model.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class DataTestOptions {
    private int delayInSeconds;
    private Data.MeasurementType[] measurementTypes;

    public DataTestOptions() {
    }

    public int getDelayInSeconds() {
        return delayInSeconds;
    }

    public void setDelayInSeconds(int delayInSeconds) {
        this.delayInSeconds = delayInSeconds;
    }

    public Data.MeasurementType[] getMeasurementTypes() {
        return measurementTypes;
    }

    public void setMeasurementTypes(Data.MeasurementType[] measurementTypes) {
        this.measurementTypes = measurementTypes;
    }
}

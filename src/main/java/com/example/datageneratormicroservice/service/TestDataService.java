package com.example.datageneratormicroservice.service;

import com.example.datageneratormicroservice.model.Test.DataTestOptions;

public interface TestDataService {
    void sendMessages(DataTestOptions testOptions);
}

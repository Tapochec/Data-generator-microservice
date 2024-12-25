package com.example.datageneratormicroservice.service;

import com.example.datageneratormicroservice.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
public class KafkaDataServiceImpl implements KafkaDataService {

    private final KafkaSender<String, Object> sender;

    @Autowired
    public KafkaDataServiceImpl(KafkaSender<String, Object> sender) {
        this.sender = sender;
    }

    @Override
    public void send(Data data) {
        String topic = switch (data.getMeasurementType()) {
            case TEMPERATURE -> "data-temperature";
            case POWER -> "data-power";
            case VOLTAGE -> "data-voltage";
        };
        sender.send(Mono.just(
                SenderRecord.create(topic, 0, System.currentTimeMillis(),
                        String.valueOf(data.hashCode()), data, null)
        )).subscribe();
    }
}

package com.example.datageneratormicroservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Configuration
public class BeanConfig {

    @Bean
    public XML producerXml() throws IOException {
        String resourcePath = "src/main/resources/kafka/producer.xml";
        Path path = Paths.get(resourcePath);

        if (!Files.exists(path)){
            throw new IOException("producer.xml not found in resources, checked at " + resourcePath);
        }

        try (InputStream inputStream = Files.newInputStream(path)) {
            return new XMLDocument(inputStream);
        }
    }
}

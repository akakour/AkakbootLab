package com.akakour.lab.json.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

/**
 * 将json中的null转出””
 */
@Configuration
public class JacksonConfiguration {

    @Bean
    @ConditionalOnMissingBean(ObjectMapper.class)
    @Primary
    public ObjectMapper json2ObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper build = builder.createXmlMapper(false).build();
        build.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }

        });
        return build;
    }
}

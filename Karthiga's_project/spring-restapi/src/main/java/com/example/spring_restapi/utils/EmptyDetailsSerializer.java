package com.example.spring_restapi.utils;

import java.io.IOException;

import com.example.spring_restapi.service.Response.Details;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class EmptyDetailsSerializer extends JsonSerializer<Details> {

    @Override
    public void serialize(Details details, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    	System.out.println("EmptyDetailsSerializer");
        if (details == null) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeEndObject();
        } else {
            jsonGenerator.writeObject(details);
        }
    }
}
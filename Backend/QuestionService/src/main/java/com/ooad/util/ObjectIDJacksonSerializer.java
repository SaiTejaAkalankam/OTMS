package com.ooad.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;

public class ObjectIDJacksonSerializer extends JsonSerializer<ObjectId> {

    @Override
    public void serialize(ObjectId value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        try {
            gen.writeString(value.toHexString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

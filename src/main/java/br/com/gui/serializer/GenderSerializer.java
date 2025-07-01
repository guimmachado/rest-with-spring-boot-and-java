package br.com.gui.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String gender, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if ("Male".equalsIgnoreCase(gender)) {
            gen.writeString("M");
        } else if ("Female".equalsIgnoreCase(gender)) {
            gen.writeString("F");
        } else if (gender == null) {
            gen.writeNull();
        } else {
            gen.writeString(gender); // fallback: write as is
        }
    }
}

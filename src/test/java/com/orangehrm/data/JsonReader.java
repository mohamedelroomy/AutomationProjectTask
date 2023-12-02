package com.orangehrm.data;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static String getValueOfKey(String key){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File jsonFile = new File("src/test/resources/ContactDetails.JSON");
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            return jsonNode.get(key).asText();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

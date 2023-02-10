package org.chakkour.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataFormatUtils {
    public static String ToJson(Object o){
        ObjectMapper objectMapper=new ObjectMapper();
        String json = null;
        try {
            json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(o);
            return json;
        } catch (JsonProcessingException e) {
            return "{ }";
            }
        }

    }

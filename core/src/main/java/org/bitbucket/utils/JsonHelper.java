package org.bitbucket.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.Optional;

public class JsonHelper {

    private static final Logger logger = LogManager.getLogger("JsonHelper");

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> Optional<String> toFormat(T object) {
        try {
            return Optional.of(mapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            logger.error(e);
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static <T> Optional<T> fromFormat(String string, Class<T> cls){
        try {
            return Optional.of(mapper.readValue(string,cls));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}

package org.bitbucket.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bitbucket.payload.Token;

import java.util.Optional;

public class JsonHelper {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LogManager.getLogger("JsonHelper");

    public static <T> Optional<String> toFormat(T object) {
        try {
            return Optional.of(mapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            //TODO - add logger
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

    public static String toJson(Token auth) {
        return null;
    }
}

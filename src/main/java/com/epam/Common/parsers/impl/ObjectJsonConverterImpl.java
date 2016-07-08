package com.epam.Common.parsers.impl;

import com.epam.Common.parsers.ObjectConverter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Evgeny_Akulenko on 7/7/2016.
 */
public class ObjectJsonConverterImpl implements ObjectConverter {
    @Override
    public String serialize(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object deserialize(String string, Class<?> classType) {
        ObjectMapper mapper = new ObjectMapper();
        Object object = null;
        try {
            object = mapper.readValue(string, classType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}

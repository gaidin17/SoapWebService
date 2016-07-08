package com.epam.Common.parsers;

/**
 * Created by Evgeny_Akulenko on 7/7/2016.
 */
public interface ObjectConverter {
    String serialize(Object obj);
    Object deserialize(String string,  Class<?> classType);
}

package com.dalivsoft.testwork.utitly;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class JsonArrayParser<T> {

    public interface  ClassFactory<T> {
        public T createObject(JsonElement jsonElement);
    }

    public List<T> parse(JsonArray array, ClassFactory<T> factory) {
        List<T> list = new ArrayList<T>(array.size());
        for (int i = 0; i < array.size(); i++) {
            T obj = factory.createObject(array.get(i));
            list.add(obj);
        }
        return list;
    }
}

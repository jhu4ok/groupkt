package util;

import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;


import java.io.BufferedReader;

@AllArgsConstructor
public class GetObjectFromJsonUtil<T> {

    BufferedReader reader;
    private Class<T> cls;


    public T getObjectFromFile() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new ArrayAdapterFactoryUtil())
                .create()
                .fromJson(reader, cls);
    }
}

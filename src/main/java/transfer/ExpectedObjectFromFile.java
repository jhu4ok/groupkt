package transfer;

import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import util.ArrayAdapterFactoryUtil;


import java.io.BufferedReader;

@AllArgsConstructor
public class ExpectedObjectFromFile<T> {

    BufferedReader reader;
    private Class<T> cls;


    public T getObjectFromFile() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new ArrayAdapterFactoryUtil())
                .create()
                .fromJson(reader, cls);
    }
}

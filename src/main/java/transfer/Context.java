package transfer;

import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import util.ArrayAdapterFactoryUtil;

@AllArgsConstructor
public class Context<T> {

    private Response response;
    private Class<T> cls;

    public int getResponseStatusCode() {
        return response.getStatusCode();
    }

    public T getObjectFromResponse() {
        String stringResponse = response.getBody().asString();
        return new GsonBuilder()
                .registerTypeAdapterFactory(new ArrayAdapterFactoryUtil())
                .create()
                .fromJson(stringResponse, cls);
    }

}

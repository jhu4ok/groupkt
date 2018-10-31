package util;

import com.google.gson.Gson;

public class JsonParserUtil {
    private Class cl;
    private Gson gson;

    public JsonParserUtil(Class cl) {
        this.cl = cl;
        gson = new Gson();
    }

    public Object deserializeResponse(String response) {
        return gson.fromJson(response, cl);
    }
}

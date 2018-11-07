package util;

public class UrlConverter {

    public static String[] splitResource(String url) {
        String[] uriReq = PropertiesUtil.getProp(url).split("/");
        return uriReq;
    }
}

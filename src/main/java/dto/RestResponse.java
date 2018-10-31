package dto;

import java.util.List;

public class RestResponse {
    private List<String> messages;
    private List<CountryDTO> result;


    public RestResponse() {
        super();
    }
    public List<String> getMessages() {
        return messages;
    }
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
    public List<CountryDTO> getResult() {
        return result;
    }
    public void setResult(List<CountryDTO> result) {
        this.result = result;
    }
    @Override
    public String toString() {
        return "RestResponse [messages=" + messages + ", result=" + result + "]";
    }



}

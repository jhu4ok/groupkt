package util;

public class ResponseMessages {

    String expectedMessageNothing = "No matching country found for requested code [";
    String expectedMessageSuccessForList = "Total [";
    String expectedMessageNothingForList = "No matching country found for requested code [";

    public String getSuccessMsgForCounry(String country){
        return "Country found matching code ["+country+"].";
    }

    public String getSuccessMsgForCounriesList (int count){
        return "Total ["+count+"] records found.";
    }

}

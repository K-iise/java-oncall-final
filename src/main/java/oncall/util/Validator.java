package oncall.util;

public class Validator {
    public void validateFormat(String input){
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.WORKINFO_ERROR.getMessage());
        }
        String[] str = input.split(",");
        if (str.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.WORKINFO_ERROR.getMessage());
        }
    }
}

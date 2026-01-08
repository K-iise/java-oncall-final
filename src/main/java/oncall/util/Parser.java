package oncall.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public String[] parseToWorkInfo(String input) {
        validator.validateWorkInfoFormat(input);
        return input.split(",");
    }

    public List<String> parseWokdTempleList(String input) {
        validator.validateWorkTempleFormat(input);
        String[] names = input.split(",");
        return new ArrayList<>(Arrays.asList(names));
    }
}

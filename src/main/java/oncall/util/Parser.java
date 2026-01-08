package oncall.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public String[] separateWorkInfo(String input) {
        return input.split(",");
    }

    public List<String> parseWokdTempleList(String input) {
        String[] names = input.split(",");
        return new ArrayList<>(Arrays.asList(names));
    }
}

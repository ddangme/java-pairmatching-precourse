package pairmatching.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseUtil {
    public static List<String> stringToListStringByTrim(String value) {
        return Arrays.stream(value.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

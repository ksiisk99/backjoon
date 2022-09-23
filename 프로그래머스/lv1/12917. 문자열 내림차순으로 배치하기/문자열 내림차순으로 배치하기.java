import java.util.stream.*;
import java.util.*;
class Solution {
    public String solution(String s) {
        return Stream.of(s.split(""))
            .sorted(Collections.reverseOrder())
            .collect(Collectors.joining());
    }
}
package pl.sda.hiddennumbers;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class HiddenNumbers {
    private static final Pattern PATTERN = Pattern.compile("-?\\d+");

    private final String lineWithNumbers;

    public HiddenNumbers(String lineWithNumbers) {
        this.lineWithNumbers = lineWithNumbers;
    }

    public int sum() {
        return PATTERN.matcher(lineWithNumbers).results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }
}

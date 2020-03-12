package pl.sda.hiddennumbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiddenNumbers {
    private static final Pattern PATTERN = Pattern.compile("-*\\d+");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private final String lineWithNumbers;

    public HiddenNumbers(String lineWithNumbers) {
        this.lineWithNumbers = lineWithNumbers;
    }

    public int sum() {
        Matcher matcher = PATTERN.matcher(lineWithNumbers);
        int sum = 0;
        while (matcher.find()) {
            String numberWithDashes = matcher.group();

            Matcher numberMatcher = NUMBER_PATTERN.matcher(numberWithDashes);
            int numberAsInt = 0;
            if(numberMatcher.find()) {
                String number = numberMatcher.group();
                numberAsInt = Integer.parseInt(number);
            }

            long dashCount = numberWithDashes.chars().filter(character -> character == '-').count();
            if (dashCount % 2 != 0) {
                sum += -1 * numberAsInt;
            } else {
                sum += numberAsInt;
            }

        }
        return sum;
    }
}

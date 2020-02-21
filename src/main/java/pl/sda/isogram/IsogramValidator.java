package pl.sda.isogram;

import java.util.HashMap;
import java.util.Map;

public class IsogramValidator {
    private final String string;

    public IsogramValidator(String string) {
        this.string = string;
    }

    public boolean isIsogram() {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char letter : string.toCharArray()) {
            if (isLetter(letter)) {
                letterCount.compute(letter, (key, value) -> {
                    if (value == null) {
                        return 1;
                    } else {
                        return ++value;
                    }
                });
            }
        }

        return letterCount.isEmpty() || letterCount.values().stream().distinct().count() == 1;
    }

    private boolean isLetter(int character) {
        return isUppercaseLetter(character) || (isLowercaseLetter(character));
    }

    private boolean isUppercaseLetter(int character) {
        return character >= 'A' && character <= 'Z';
    }

    private boolean isLowercaseLetter(int character) {
        return character >= 'a' && character <= 'z';
    }
}

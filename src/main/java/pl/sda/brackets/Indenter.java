package pl.sda.brackets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Indenter {
    private static final int INDENT_LEVEL_SPACES = 4;

    private final String textToIndent;

    public Indenter(String textToIndent) {
        if(textToIndent.chars()
                .mapToObj(String::valueOf)
                .noneMatch(this::isBracket)) {
            throw new NoBracketsException("Brackets are missing");
        }
        this.textToIndent = textToIndent;
    }

    public String getIndented() {
        String inflatedText = textToIndent.chars()
                .mapToObj(Character::toString)
                .map(this::withBracketInNewline)
                .collect(Collectors.joining());

        List<String> lines = Arrays.stream(inflatedText.split("\n"))
                .filter(line -> !line.isBlank())
                .map(String::trim)
                .collect(Collectors.toList());

        return indented(lines);
    }

    private String indented(List<String> lines) {
        StringBuilder stringBuilder = new StringBuilder();
        int indentLevel = 0;
        for (String line : lines) {
            if(isClosingBracket(line)) {
                --indentLevel;
            }

            stringBuilder.append(indentation(indentLevel))
                    .append(line)
                    .append("\n");

            if (isOpeningBracket(line)) {
                ++indentLevel;
            }
        }
        return stringBuilder.toString().trim();
    }

    private String withBracketInNewline(String character) {
        if (isBracket(character)) {
            return "\n" + character + "\n";
        }
        return character;
    }

    private String indentation(int level) {
        return IntStream.range(0, level * INDENT_LEVEL_SPACES).mapToObj(ignored -> " ").collect(Collectors.joining());
    }

    private boolean isBracket(String string) {
        return isOpeningBracket(string) || isClosingBracket(string);
    }

    private boolean isOpeningBracket(String string) {
        if(string.length() != 1) {
            return false;
        }
        return isOpeningBracket(string.charAt(0));
    }

    private boolean isOpeningBracket(char character) {
        return character == '(' || character == '[' || character == '{';
    }

    private boolean isClosingBracket(String string) {
        if(string.length() != 1) {
            return false;
        }
        return isClosingBracket(string.charAt(0));
    }

    private boolean isClosingBracket(char character) {
        return character == ')' || character == ']' || character == '}';
    }
}

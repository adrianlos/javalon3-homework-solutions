package pl.sda.brackets;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Indenter {
    private static final int INDENT_LEVEL_SPACES = 4;

    private final String textToIndent;

    public Indenter(String textToIndent) {
        this.textToIndent = textToIndent;
    }

    public String getIndented() {
        String textWithoutNewlines = textToIndent.replace("\n", "");
        int indentationLevel = 0;
        StringBuilder resultBuilder = new StringBuilder();
        for (char character : textWithoutNewlines.toCharArray()) {
            resultBuilder.append(indentation(indentationLevel))
                    .append(character);
            if(isOpeningBracket(character)) {
                ++indentationLevel;
            } else if(isClosingBracket(character)) {
                --indentationLevel;
            }
        }
        return resultBuilder.toString();
    }

    private String indentation(int level) {
        return IntStream.range(0, level * INDENT_LEVEL_SPACES).mapToObj(ignored -> " ").collect(Collectors.joining());
    }

    private boolean isOpeningBracket(char character) {
        return character == '(' || character == '[' || character == '{';
    }

    private boolean isClosingBracket(char character) {
        return character == ')' || character == ']' || character == '}';
    }
}

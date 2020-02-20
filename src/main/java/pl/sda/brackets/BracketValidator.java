package pl.sda.brackets;

import java.util.Stack;

public class BracketValidator {
    private final String stringToValidate;

    public BracketValidator(String stringToValidate) {
        this.stringToValidate = stringToValidate;
    }

    public boolean isValid() {
        Stack<Character> bracketStack = new Stack<>();
        for (char character : stringToValidate.toCharArray()) {
            if (isOpeningBracket(character)) {
                bracketStack.push(character);
            } else if (isClosingBracket(character)) {
                if (bracketStack.isEmpty() || !bracketsMatch(bracketStack.pop(), character)) {
                    return false;
                }
            }
        }
        return bracketStack.empty();
    }

    private boolean isOpeningBracket(char character) {
        return character == '(' || character == '[' || character == '{';
    }

    private boolean isClosingBracket(char character) {
        return character == ')' || character == ']' || character == '}';
    }

    private boolean bracketsMatch(Character openingBracket, Character closingBracket) {
        switch (openingBracket) {
            case '(': return closingBracket == ')';
            case '[': return closingBracket == ']';
            case '{': return closingBracket == '}';
        }
        return false;
    }

}

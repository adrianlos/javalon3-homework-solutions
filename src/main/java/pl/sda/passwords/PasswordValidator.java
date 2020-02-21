package pl.sda.passwords;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PasswordValidator {
    private static final List<Predicate<String>> VALID_PASSWORD_PATTERNS = List.of(
            Pattern.compile("[A-Z]").asPredicate(),
            Pattern.compile("[a-z]").asPredicate(),
            Pattern.compile("[0-9]").asPredicate(),
            Pattern.compile("[!@#$%^&*()\\-=;:/?<>,.'\"|\\\\`~+_]").asPredicate()
    );
    private final String password;

    public PasswordValidator(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return password.length() >= 8 && VALID_PASSWORD_PATTERNS.stream().allMatch(stringPredicate -> stringPredicate.test(password));
    }
}

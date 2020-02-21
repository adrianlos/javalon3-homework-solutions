package pl.sda.encryptor;

import java.util.stream.Collectors;

public class Encryptor {
    private final String notEncryptedString;
    private final int rotation;

    public Encryptor(String notEncryptedString, int rotation) {
        this.notEncryptedString = notEncryptedString;
        this.rotation = rotation;
    }

    public String encryptedText() {
        return notEncryptedString.chars()
                .map(this::rotateIfLetter)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    private int rotateIfLetter(int character) {
        if(isLetter(character)) {
            return rotateLetter(character);
        }
        return character;
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

    private int rotateLetter(int character) {
        if(isUppercaseLetter(character)){
            return (character - 'A' + rotation) % ('Z' - 'A' + 1) + 'A';
        } else {
            return (character - 'a' + rotation) % ('z' - 'a' + 1) + 'a';
        }
    }
}

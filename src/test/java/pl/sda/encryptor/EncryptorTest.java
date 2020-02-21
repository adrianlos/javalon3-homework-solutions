package pl.sda.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptorTest {

    @Test
    void shouldRotateLowercase() {
        //given
        String unencryptedText = "abcdefg";
        Encryptor encryptor = new Encryptor(unencryptedText, 1);
        String expected = "bcdefgh";
        //when
        String encryptedText = encryptor.encryptedText();
        //then
        assertEquals(expected, encryptedText);
    }

    @Test
    void shouldRotateUppercase() {
        //given
        String unencryptedText = "ABCDEFG";
        Encryptor encryptor = new Encryptor(unencryptedText, 1);
        String expected = "BCDEFGH";
        //when
        String encryptedText = encryptor.encryptedText();
        //then
        assertEquals(expected, encryptedText);
    }

    @Test
    void shouldRotateOnlyLetters() {
        //given
        String unencryptedText = "a;b1cD(ef?g";
        Encryptor encryptor = new Encryptor(unencryptedText, 2);
        String expected = "c;d1eF(gh?i";
        //when
        String encryptedText = encryptor.encryptedText();
        //then
        assertEquals(expected, encryptedText);
    }

    @Test
    void shouldRotatePastZ() {
        //given
        String unencryptedText = "abcxyz";
        Encryptor encryptor = new Encryptor(unencryptedText, 2);
        String expected = "cdezab";
        //when
        String encryptedText = encryptor.encryptedText();
        //then
        assertEquals(expected, encryptedText);
    }

    @Test
    void shouldRotateTwicePastZ() {
        //given
        String unencryptedText = "abcxyz";
        Encryptor encryptor = new Encryptor(unencryptedText, 28);
        String expected = "cdezab";
        //when
        String encryptedText = encryptor.encryptedText();
        //then
        assertEquals(expected, encryptedText);
    }

}
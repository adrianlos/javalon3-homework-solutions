package pl.sda.isogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsogramValidatorTest {

    @Test
    void shouldValidateEmptyString() {
        //given
        String input = "";
        IsogramValidator isogramValidator = new IsogramValidator(input);
        //when
        boolean isIsogram = isogramValidator.isIsogram();
        //then
        assertTrue(isIsogram);
    }

    @Test
    void shouldValidateLettersOnly() {
        //given
        String input = "abcbac";
        IsogramValidator isogramValidator = new IsogramValidator(input);
        //when
        boolean isIsogram = isogramValidator.isIsogram();
        //then
        assertTrue(isIsogram);
    }

    @Test
    void shouldOmitNonLetters() {
        //given
        String input = "ab;cba/c";
        IsogramValidator isogramValidator = new IsogramValidator(input);
        //when
        boolean isIsogram = isogramValidator.isIsogram();
        //then
        assertTrue(isIsogram);
    }

    @Test
    void shouldNotValidateNonIsogram() {
        //given
        String input = "abca";
        IsogramValidator isogramValidator = new IsogramValidator(input);
        //when
        boolean isIsogram = isogramValidator.isIsogram();
        //then
        assertFalse(isIsogram);
    }



}
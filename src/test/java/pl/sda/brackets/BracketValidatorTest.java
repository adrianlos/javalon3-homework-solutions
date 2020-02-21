package pl.sda.brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketValidatorTest {

    @Test
    void shouldValidateStringWithBracketsOnly() {
        //given
        String input = "[{()}]";
        //when
        boolean validationResult = new BracketValidator(input).isValid();
        //then
        assertTrue(validationResult);
    }

    @Test
    void shouldValidateStringWithTextInsideBrackets() {
        //given
        String input = "[ to ( jest )] test";
        //when
        boolean validationResult = new BracketValidator(input).isValid();
        //then
        assertTrue(validationResult);
    }

    @Test
    void shouldNotValidateStringWithDifferentBrackets() {
        //given
        String input = "[ tak ] już { nie )";
        //when
        boolean validationResult = new BracketValidator(input).isValid();
        //then
        assertFalse(validationResult);
    }

    @Test
    void shouldNotValidateStringWithMixedBrackets() {
        //given
        String input = "[ tak ( ] nie ) jest dobrze";
        //when
        boolean validationResult = new BracketValidator(input).isValid();
        //then
        assertFalse(validationResult);
    }

    @Test
    void shouldNotFailOnOddBracketCount() {
        //given
        String input = "tak ( nie ) ] jest dobrze";
        //when
        boolean validationResult = new BracketValidator(input).isValid();
        //then
        assertFalse(validationResult);
    }

    @Test
    void shouldNotValidateStringWithExcessive() {
        //given
        String input = "tak ( ( nie ) jest dobrze";
        //when
        boolean validationResult = new BracketValidator(input).isValid();
        //then
        assertFalse(validationResult);
    }

}
package pl.sda.brackets;

import org.junit.jupiter.api.Test;

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

}
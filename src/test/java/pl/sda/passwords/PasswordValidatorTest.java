package pl.sda.passwords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void shouldValidateComplexPassword() {
        //given
        String input = "SomeComplexP4$$w0rd";
        PasswordValidator passwordValidator = new PasswordValidator(input);
        //when
        boolean result = passwordValidator.isValid();
        //then
        assertTrue(result);
    }

    @Test
    void shouldNotValidateTooShortPassword() {
        //given
        String input = "P4$w0rd";
        PasswordValidator passwordValidator = new PasswordValidator(input);
        //when
        boolean result = passwordValidator.isValid();
        //then
        assertFalse(result);
    }

    @Test
    void shouldNotValidatePasswordWithNoUppercases() {
        //given
        String input = "somecomplexp4$$w0rd";
        PasswordValidator passwordValidator = new PasswordValidator(input);
        //when
        boolean result = passwordValidator.isValid();
        //then
        assertFalse(result);
    }

    @Test
    void shouldNotValidatePasswordWithNoLowercases() {
        //given
        String input = "SOMECOMPLEXP4$$W0RD";
        PasswordValidator passwordValidator = new PasswordValidator(input);
        //when
        boolean result = passwordValidator.isValid();
        //then
        assertFalse(result);
    }

    @Test
    void shouldNotValidatePasswordWithNoSpecialChars() {
        //given
        String input = "SomeComplexP4ssw0rd";
        PasswordValidator passwordValidator = new PasswordValidator(input);
        //when
        boolean result = passwordValidator.isValid();
        //then
        assertFalse(result);
    }

    @Test
    void shouldNotValidatePasswordWithNoNumbers() {
        //given
        String input = "SomeComplexPa$$word";
        PasswordValidator passwordValidator = new PasswordValidator(input);
        //when
        boolean result = passwordValidator.isValid();
        //then
        assertFalse(result);
    }

}
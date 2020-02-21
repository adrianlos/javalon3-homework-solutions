package pl.sda.evaluator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsciiCharacterEvaluationStrategyTest {

    private static final AsciiCharacterEvaluationStrategy strategy = new AsciiCharacterEvaluationStrategy();

    @Test
    void shouldEvaluateNullAs0() {
        //given
        Character input = null;
        int expected = 0;
        //when
        int result = strategy.evaluate(input);
        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldEvaluateCharacterToAsciiIndex() {
        //given
        Character input = 'a';
        int expected = 'a';
        //when
        int result = strategy.evaluate(input);
        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldEvaluateNonLetters() {
        //given
        Character input = '?';
        int expected = '?';
        //when
        int result = strategy.evaluate(input);
        //then
        assertEquals(expected, result);
    }



}
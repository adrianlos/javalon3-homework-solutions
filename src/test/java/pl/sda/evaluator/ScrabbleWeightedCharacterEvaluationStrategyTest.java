package pl.sda.evaluator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleWeightedCharacterEvaluationStrategyTest {

    ScrabbleWeightedCharacterEvaluationStrategy strategy = new ScrabbleWeightedCharacterEvaluationStrategy();

    @Test
    void shouldEvaluateUpperCase() {
        //given
        Character input = 'A';
        int expected = 1;
        //when
        int result = strategy.evaluate(input);
        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldEvaluateLowerCase() {
        //given
        Character input = 'a';
        int expected = 1;
        //when
        int result = strategy.evaluate(input);
        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldNotEvaluateNonLetters() {
        //given
        Character input = '?';
        int expected = 0;
        //when
        int result = strategy.evaluate(input);
        //then
        assertEquals(expected, result);
    }

}
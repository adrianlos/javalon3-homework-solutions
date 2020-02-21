package pl.sda.evaluator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringEvaluatorTest {

    @Test
    void shouldCallEvaluateForEachCharacter() {
        //given
        String input = "abcdef123?";
        StringEvaluator stringEvaluator = new StringEvaluator(input, new CountingCharacterEvaluationStrategy());
        int expected = 10;
        //when
        int result = stringEvaluator.getValue();
        //then
        assertEquals(expected, result);
    }

    private static class CountingCharacterEvaluationStrategy implements CharacterEvaluationStrategy {
        @Override
        public int evaluate(Character character) {
            return 1;
        }
    }

}
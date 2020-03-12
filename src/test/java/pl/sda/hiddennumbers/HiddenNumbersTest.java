package pl.sda.hiddennumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HiddenNumbersTest {

    @Test
    void shouldSumPositiveInts() {
        //given
        String input = "a1b2c30";
        //when
        int sum = new HiddenNumbers(input).sum();
        //then
        assertEquals(33, sum);
    }

    @Test
    void shouldSumPositiveAndNegativeInts() {
        //given
        String input = "a1b2-c-30";
        //when
        int sum = new HiddenNumbers(input).sum();
        //then
        assertEquals(-27, sum);
    }

    @Test
    void shouldIgnoreMultipleDashes() {
        //given
        String input = "a1b2-c--30";
        //when
        int sum = new HiddenNumbers(input).sum();
        //then
        assertEquals(33, sum);
    }

    @Test
    void shouldReturn0OnNoNumbers() {
        //given
        String input = "ab--c";
        //when
        int sum = new HiddenNumbers(input).sum();
        //then
        assertEquals(0, sum);
    }

}
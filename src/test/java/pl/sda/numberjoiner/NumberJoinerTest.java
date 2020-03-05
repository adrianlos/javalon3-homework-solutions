package pl.sda.numberjoiner;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberJoinerTest {

    @Test
    void shouldJoinPositiveNumbers() {
        //given
        List<Integer> numbersToJoin = List.of(1,2,3);
        //when
        String string = new NumberJoiner(numbersToJoin).asString();
        //then
        assertEquals("123", string);
    }

    @Test
    void shouldJoinPositiveAndNegativeNumbers() {
        //given
        List<Integer> numbersToJoin = List.of(1,-2,3);
        //when
        String string = new NumberJoiner(numbersToJoin).asString();
        //then
        assertEquals("1-23", string);
    }

    @Test
    void shouldProduceEmptyStringOnEmptyLis() {
        //given
        //when
        String string = new NumberJoiner(Collections.emptyList()).asString();
        //then
        assertEquals("", string);
    }

}
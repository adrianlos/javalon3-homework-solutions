package pl.sda.brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndenterTest {

    @Test
    void shouldIndentTextWithBrackets() {
        //given
        String input = "( to jest ) test";
        String expected =
                "(\n" +
                "    to jest\n" +
                ")\n" +
                "test";
        //when
        String indented = new Indenter(input).getIndented();
        //then
        assertEquals(expected, indented);
    }

    @Test
    void shouldIndentTextWithMultipleBrackets() {
        //given
        String input = "( to {jest} ) test";
        String expected =
                "(\n" +
                "    to\n" +
                "    {\n" +
                "        jest\n" +
                "    }\n" +
                ")\n" +
                "test";
        //when
        String indented = new Indenter(input).getIndented();
        //then
        assertEquals(expected, indented);
    }

    @Test()
    void shouldThrowException() {
        //given
        String string = "123";
        //then
        assertThrows(NoBracketsException.class, () -> new Indenter(string));
    }

}
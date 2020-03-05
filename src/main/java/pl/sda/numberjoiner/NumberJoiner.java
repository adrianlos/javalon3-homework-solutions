package pl.sda.numberjoiner;

import java.util.List;
import java.util.stream.Collectors;

public class NumberJoiner {
    private final List<Integer> numbers;

    public NumberJoiner(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String asString() {
        return numbers.stream()
                .map(number -> Integer.toString(number))
                .collect(Collectors.joining());
    }
}

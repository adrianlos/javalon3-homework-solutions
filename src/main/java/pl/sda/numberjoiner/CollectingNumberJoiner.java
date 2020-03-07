package pl.sda.numberjoiner;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectingNumberJoiner {
    private final List<Integer> numbers;

    public CollectingNumberJoiner(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String asString() {
        Collector<Integer, StringBuilder, String> intJoiningCollector =
                Collector.of(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString);
        return numbers.stream().collect(new IntJoiningCollector());
    }

    private static class IntJoiningCollector implements Collector<Integer, StringBuilder, String> {

        @Override
        public Supplier<StringBuilder> supplier() {
            return StringBuilder::new;
        }

        @Override
        public BiConsumer<StringBuilder, Integer> accumulator() {
            return StringBuilder::append;
        }

        @Override
        public BinaryOperator<StringBuilder> combiner() {
            return StringBuilder::append;
        }

        @Override
        public Function<StringBuilder, String> finisher() {
            return StringBuilder::toString;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }
}

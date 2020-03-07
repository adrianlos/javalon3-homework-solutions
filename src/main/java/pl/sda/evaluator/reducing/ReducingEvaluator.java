package pl.sda.evaluator.reducing;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReducingEvaluator {
    private final String textToEvaluate;

    public int getValue() {
        return textToEvaluate.chars().reduce(0, new SummingReductor());
    }
}

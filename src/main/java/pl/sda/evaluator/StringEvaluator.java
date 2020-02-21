package pl.sda.evaluator;

public class StringEvaluator {
    private final String textToEvaluate;
    private final CharacterEvaluationStrategy evaluationStrategy;

    public StringEvaluator(String textToEvaluate, CharacterEvaluationStrategy evaluationStrategy) {
        this.textToEvaluate = textToEvaluate;
        this.evaluationStrategy = evaluationStrategy;
    }

    public int getValue() {
        return textToEvaluate.chars()
                .mapToObj(character -> (char) character)
                .map(evaluationStrategy::evaluate)
                .reduce(0, Integer::sum);
    }


}

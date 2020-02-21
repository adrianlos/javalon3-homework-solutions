package pl.sda.evaluator;

public class AsciiCharacterEvaluationStrategy implements CharacterEvaluationStrategy {
    @Override
    public int evaluate(Character character) {
        if(character == null) {
            return 0;
        }
        return character;
    }
}

package pl.sda.evaluator;

public class Karol implements CharacterEvaluationStrategy{

    @Override
    public int evaluate(Character character) {
        if(Character.isLetter(character)) {
            if (Character.isUpperCase(character)){
                return Character.toLowerCase(character);
            }
            Character upperCase = Character.toUpperCase(character);
            return (int) upperCase;
        }
        return 0;
    }
}

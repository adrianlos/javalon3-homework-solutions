package pl.sda.evaluator.reducing;

import java.util.function.IntBinaryOperator;

public class SummingReductor implements IntBinaryOperator {
    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}

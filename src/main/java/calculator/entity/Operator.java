package calculator.entity;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),
    SUBTRACT("-", (t, u) -> t - u),
    MULTIPLY("*", (t, u) -> t * u),
    DIVISION("/", (t, u) -> t / u);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> arithmetic;

    Operator(String operator, BiFunction<Integer, Integer, Integer> arithmetic) {
        this.operator = operator;
        this.arithmetic = arithmetic;
    }

    public BiFunction<Integer, Integer, Integer> getArithmetic() {
        return this.arithmetic;
    }

    public static Operator of(String inputOp) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(inputOp))
                .findFirst()
                .get();
    }

    public static boolean isOperator(String inputOp) {
        return Arrays.stream(values())
                .anyMatch(op -> op.operator.equals(inputOp));
    }
}

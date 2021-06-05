package calculator.service;

import calculator.entity.StringInput;
import calculator.entity.Operator;

import java.util.Queue;

public class StringCalculator {

    public int getResult(String input) {
        return calculate(new StringInput(input).getValue());
    }

    private int calculate(Queue<String> values) {
        int result = Integer.parseInt(values.poll());

        while (!values.isEmpty()) {
            String op = values.poll();
            int number = Integer.parseInt(values.poll());

            result = Operator.of(op)
                    .getArithmetic()
                    .apply(result, number);
        }
        return result;
    }
}

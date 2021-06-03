package calculator.service;

import calculator.entity.StringInput;
import calculator.entity.Operator;

import java.util.Queue;

public class StringCalculator {
    private final StringInput stringInput = new StringInput();

    public int getResult(String input) {
        stringInput.setValues(input);
        return calculate(stringInput.getValues());
    }

    private int calculate(Queue<String> values) {
        int result = 0;
        if (!values.isEmpty()) {
            result = Integer.parseInt(values.poll());
        }

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

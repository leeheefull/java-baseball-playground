package calculator.entity;

import calculator.utils.Constants;
import calculator.utils.StringUtil;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class StringInput {
    private final Queue<String> value = new LinkedList<>();

    public StringInput(String input) {
        String[] inputs = input.split(" ");
        if (inputs.length <= Constants.MINIMUM_SIZE) {
            throw new InputMismatchException("입력값 오류!");
        }
        for (int i = 0; i < inputs.length; i++) {
            validate(i, inputs[i], inputs.length);
            value.add(inputs[i]);
        }
    }

    public Queue<String> getValue() {
        return value;
    }

    private void validate(int idx, String value, int valuesSize) {
        boolean numberValidation = idx % 2 == 0 && !StringUtil.isNumber(value);
        boolean operatorValidation = idx % 2 == 1 && !Operator.isOperator(value);
        boolean lastPositionValidation = idx == valuesSize - 1 && !StringUtil.isNumber(value);

        if (numberValidation || operatorValidation || lastPositionValidation) {
            throw new InputMismatchException("입력값 오류!");
        }
    }
}

package calculator.entity;

import calculator.utils.StringUtil;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

public class StringInput {
    private final Queue<String> values = new LinkedList<>();

    public Queue<String> getValues() {
        return values;
    }

    public void setValues(String str) {
        String[] values = str.split(" ");
        if (values.length <= StringUtil.MINIMUM_SIZE) {
            throw new InputMismatchException("입력값 오류!");
        }
        for (int i = 0; i < values.length; i++) {
            validate(i, values[i], values.length);
            this.values.add(values[i]);
        }
    }

    private void validate(int idx, String value, int valuesSize) {
        boolean numberValidation = idx % 2 == 0 && StringUtil.isNumber(value);
        boolean operatorValidation = idx % 2 == 1 && !Operator.isOperator(value);
        boolean lastPositionValidation = idx == valuesSize - 1 && StringUtil.isNumber(value);

        if (numberValidation || operatorValidation || lastPositionValidation) {
            throw new InputMismatchException("입력값 오류!");
        }
    }
}

package baseball.entity;

import baseball.utils.BaseballConstants;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class BaseballNo {
    private final List<Integer> numbers;

    public BaseballNo(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        if (!validateNumber(numbers)) {
            throw new InputMismatchException("입력 값 오류!");
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean validateNumber(List<Integer> numbers) {
        boolean isBig = BaseballConstants.PROPER_NO < numbers.size();
        boolean isSmall = numbers.stream()
                .distinct()
                .count() < BaseballConstants.PROPER_NO;
        boolean outOfValue = numbers.stream()
                .noneMatch(n -> n < BaseballConstants.MIN_NO || BaseballConstants.MAX_NO < n);

        return isBig || isSmall || outOfValue;
    }
}

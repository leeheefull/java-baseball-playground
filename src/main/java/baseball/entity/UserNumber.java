package baseball.entity;

import baseball.utils.BaseballConstants;

import java.util.*;

public class UserNumber {
    private List<Integer> numbers;

    public UserNumber() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> inputNo) {
        if (!validateNumber(inputNo)) {
            throw new InputMismatchException("입력 값 오류!");
        }
        this.numbers = inputNo;
    }

    private boolean validateNumber(List<Integer> userNumbers) {
        if (new LinkedHashSet<>(userNumbers).size() < BaseballConstants.NUMBER_SIZE) {
            return false;
        }
        for (Integer n : userNumbers) {
            if (n < 1 || 9 < n) {
                return false;
            }
        }
        return true;
    }
}

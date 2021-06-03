package baseball.game;

import baseball.entity.BallStatus;
import baseball.entity.UserNumber;
import baseball.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Integer> computerNumbers = RandomGenerator.numbers();
    private UserNumber userNumbers;
    private BallStatus ballStatus;

    public BaseballGame() {
        this.userNumbers = new UserNumber();
        this.ballStatus = new BallStatus();
    }

    public void setUserNumbers(String input) {
        List<Integer> inputNo = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNo.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        this.userNumbers.setNumbers(inputNo);
    }

    public BallStatus getResult() {
        for (int i = 0; i < computerNumbers.size(); i++) {
            compare(i, computerNumbers.get(i));
        }
        return ballStatus;
    }

    private void compare(int idx, int value) {
        if (compareStrike(idx, value)) {
            compareBall(computerNumbers.get(idx));
        }
    }

    private boolean compareStrike(int idx, int value) {
        if (userNumbers.getNumbers().get(idx) == value) {
            ballStatus.hitStrike();
            return false;
        }
        return true;
    }

    private void compareBall(int value) {
        if (userNumbers.getNumbers().contains(value)) {
            ballStatus.hitBall();
        }
    }
}

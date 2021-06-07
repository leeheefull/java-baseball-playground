package baseball.entity;

import baseball.utils.BaseballConstants;

public class BallStatus {
    private int strike;
    private int ball;

    public BallStatus() {
        this(0, 0);
    }

    public BallStatus(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void clear() {
        new BallStatus();
    }

    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }

    public boolean isEndInning() {
        return this.strike == BaseballConstants.END_INNING_FLAG;
    }

    public BallStatus getResult(ComputerNo computerNumber, UserNo userNumber) {
        for (int i = 0; i < computerNumber.getNumbers().size(); i++) {
            compare(computerNumber, userNumber, i, computerNumber.getNumbers().get(i));
        }
        return new BallStatus(this.strike, this.ball);
    }

    private void compare(ComputerNo computerNumber, UserNo userNumber, int idx, int value) {
        if (compareStrike(userNumber, idx, value)) {
            compareBall(userNumber, computerNumber.getNumbers().get(idx));
        }
    }

    private boolean compareStrike(UserNo userNumber, int idx, int value) {
        if (userNumber.getNumbers().get(idx) == value) {
            this.strike++;
            return false;
        }
        return true;
    }

    private void compareBall(UserNo userNumber, int value) {
        if (userNumber.getNumbers().contains(value)) {
            this.ball++;
        }
    }

    @Override
    public String toString() {
        return "-> " + ball + "볼 " + strike + "스트라이크";
    }
}

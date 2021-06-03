package baseball.entity;

public class BallStatus {
    private int strike;
    private int ball;

    public BallStatus() {
        strike = 0;
        ball = 0;
    }

    public void clear() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void hitStrike() {
        this.strike++;
    }

    public void hitBall() {
        this.ball++;
    }
}

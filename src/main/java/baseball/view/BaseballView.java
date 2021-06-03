package baseball.view;

import baseball.entity.BallStatus;

import java.io.PrintStream;

public class BaseballView {
    PrintStream out = new PrintStream(System.out);

    public void showInput() {
        out.print("숫자를 입력해주세요 : ");
    }

    public void showBallStatus(BallStatus ballStatus) {
        out.println(ballStatus.getBall() + "볼 " + ballStatus.getStrike() + "스트라이크");
    }

    public void showEnd() {
        out.print("종료");
    }
}

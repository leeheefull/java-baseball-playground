package baseball.view;

import baseball.entity.BallStatus;

import java.io.PrintStream;

public class BaseballView {
    PrintStream out = new PrintStream(System.out);

    public void showMenu() {
        out.print("* 다시하기(1), 종료(2): ");
    }

    public void showInput() {
        out.print("* 숫자를 입력해주세요 : ");
    }

    public void showBallStatus(BallStatus ballStatus) {
        out.println(ballStatus.toString());
    }

    public void showEnd() {
        out.println("* 종료");
    }

    public void showNothing() {
        out.println("* 낫싱");
    }
}

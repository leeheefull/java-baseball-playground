package baseball.game;

import baseball.entity.BallStatus;
import baseball.entity.ComputerNo;
import baseball.entity.UserNo;

public class BaseballGame {
    private final ComputerNo computerNumber;
    private UserNo userNumber;

    public BaseballGame() {
        this.computerNumber = new ComputerNo();
    }

    public void makeUserNumber(String input) {
        this.userNumber = new UserNo(input);
    }

    public BallStatus playInning() {
        return new BallStatus().getResult(computerNumber, userNumber);
    }
}

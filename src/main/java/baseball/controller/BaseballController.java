package baseball.controller;

import baseball.entity.BallStatus;
import baseball.exception.ExitException;
import baseball.game.BaseballGame;
import baseball.utils.BaseballConstants;
import baseball.view.BaseballView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseballController {
    private final BaseballView view = new BaseballView();

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            BaseballGame game = new BaseballGame();
            while (true) {
                String input = inputNum(br);
                game.makeUserNumber(input);
                BallStatus ball = game.playInning();

                if (ball.isNothing()) {
                    view.showNothing();
                }
                if (!ball.isNothing()) {
                    view.showBallStatus(ball);
                }
                if (ball.isEndInning()) {
                    view.showEnd();
                    exit(inputMenu(br));
                    game = new BaseballGame();
                }
                ball.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String inputMenu(BufferedReader br) throws IOException {
        view.showMenu();
        return br.readLine();
    }

    private String inputNum(BufferedReader br) throws IOException {
        view.showInput();
        return br.readLine();
    }

    private void exit(String inputMenu) throws ExitException {
        if (inputMenu.equals(BaseballConstants.END_GAME_FLAG)) {
            throw new ExitException();
        }
    }
}

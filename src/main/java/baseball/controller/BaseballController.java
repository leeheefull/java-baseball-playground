package baseball.controller;

import baseball.entity.BallStatus;
import baseball.game.BaseballGame;
import baseball.view.BaseballView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseballController {
    private final BaseballView view = new BaseballView();
    private final BaseballGame game = new BaseballGame();

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = inputNum(br);
                game.setUserNumbers(input);

                BallStatus result = game.getResult();
                view.showBallStatus(result);

                if (result.getStrike() == 3) {
                    view.showEnd();
                    return;
                }
                result.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String inputNum(BufferedReader br) throws IOException {
        view.showInput();
        return br.readLine();
    }
}

package baseball.entity;

import baseball.utils.RandomGenerator;

public class ComputerNo extends BaseballNo {

    public ComputerNo() {
        super(RandomGenerator.numbers());
    }
}
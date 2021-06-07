package baseball.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomGenerator {

    public static String numbers() {
        return ThreadLocalRandom.current()
                .ints(BaseballConstants.MIN_NO, BaseballConstants.MAX_NO - 1)
                .distinct()
                .limit(BaseballConstants.PROPER_NO)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}

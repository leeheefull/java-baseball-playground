package baseball.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RandomGenerator {

    public static List<Integer> numbers() {
        Set<Integer> randomNumbers = new LinkedHashSet<>();

        while (randomNumbers.size() < 3) {
            randomNumbers.add((int) (Math.random() * 9) + 1);
        }
        return new ArrayList<>(randomNumbers);
    }
}

package baseball;

import baseball.utils.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤 생성 성공 검사")
    void successRandomGenerate() {
        // given
        RandomGenerator randomGenerator = new RandomGenerator();

        for (int n : RandomGenerator.numbers()) {
            // when
            boolean isTrue = 0 < n && n < 10;
            // then
            assertThat(isTrue).isEqualTo(true);
        }
    }
}

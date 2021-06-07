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

        for (char c : RandomGenerator.numbers().toCharArray()) {
            // when
            boolean isTrue = '0' < c && c <= '9';
            // then
            assertThat(isTrue).isEqualTo(true);
        }
    }
}

package calculator;

import calculator.service.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("출력 값 성공 검사")
    @ParameterizedTest
    @CsvSource(value = {
            "5 + 3:8",
            "10 - 5:5",
            "3 * 9:27",
            "12 / 4:3",
            "10 * 2 / 2 / 2:5",
            "20 + 3 * 4 / 2:46",
            "0 * 2 + 2:2"
    }, delimiter = ':')
    void successStringCalculator(String input, int expected) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int actual = stringCalculator.getResult(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("출력 값 오류 검사")
    @ValueSource(strings = {
            "1",
            "2 2",
            "+ 2 -",
            "- * /",
            "2 + + 3",
            "3 - 3 -",
            "+ + + + -",
            "_ = |",
            "p + 2 - x"
    })
    void failStringCalculator(String input) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when, then
        assertThatThrownBy(() -> {
            stringCalculator.getResult(input);
        }).isInstanceOf(InputMismatchException.class);
    }
}

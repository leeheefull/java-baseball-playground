package calculator;

import calculator.service.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        this.stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("계산 성공 검사")
    @CsvSource(value = {
            "5 + 3:8",
            "10 - 5:5",
            "3 * 9:27",
            "12 / 4:3",
            "20 + 3 * 4 / 2:46",
            "0 * 2 + 2:2"
    }, delimiter = ':')
    void successGetValue(String input, int expected) {
        // when
        int actual = stringCalculator.getResult(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("계산 오류 검사")
    @ValueSource(strings = {
            "1234 / 0"
    })
    void failStringCalculator(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.getResult(input);
        }).isInstanceOf(ArithmeticException.class);
    }
}

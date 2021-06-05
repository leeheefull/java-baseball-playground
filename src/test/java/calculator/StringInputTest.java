package calculator;

import calculator.entity.StringInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringInputTest {
    @ParameterizedTest
    @DisplayName("입력 값 성공 검사")
    @ValueSource(strings = {
            "5 + 3 ",
            "10 - 5 ",
            "3 * 9 ",
            "12 / 4 ",
            "10 + 2 - 2 * 2 / 2 ",
            "0 * 2 + 2 ",
            "-1 * -2 + 5 "
    })
    void successStringInput(String input) {
        // given
        StringInput stringInput = new StringInput(input);
        String actual = "";

        // when
        for (String value : stringInput.getValue()) {
            actual += value + " ";
        }

        // then
        assertThat(actual).isEqualTo(input);
    }

    @ParameterizedTest
    @DisplayName("입력 값 오류 검사")
    @ValueSource(strings = {
            "1",
            "2 2",
            "+ 2 -",
            "- * /",
            "_ = |",
            "p + 2 - x"
    })
    void failStringInput(String input) {
        // given, when, then
        assertThatThrownBy(() -> {
            new StringInput(input);
        }).isInstanceOf(InputMismatchException.class);
    }
}

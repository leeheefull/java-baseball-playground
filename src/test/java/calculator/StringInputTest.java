package calculator;

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
            "10 * 2 / 2 / 2 ",
            "20 + 3 * 4 / 2 ",
            "0 * 2 + 2 "
    })
    void successStringInput(String input) {
        // given
        calculator.entity.StringInput stringInput = new calculator.entity.StringInput();
        String actual = "";

        // when
        stringInput.setValues(input);
        for (String value : stringInput.getValues()) {
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
            "2 + + 3",
            "3 - 3 -",
            "+ + + + -",
            "_ = |",
            "p + 2 - x"
    })
    void failStringInput(String input) {
        // given
        calculator.entity.StringInput stringInput = new calculator.entity.StringInput();

        // when, then
        assertThatThrownBy(() -> {
            stringInput.setValues(input);
        }).isInstanceOf(InputMismatchException.class);
    }
}

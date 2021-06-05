package calculator;

import calculator.entity.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class OperatorTest {
    @ParameterizedTest
    @DisplayName("of() 성공 검사")
    @CsvSource(value = {
            "+:PLUS", "-:SUBTRACT", "*:MULTIPLY", "/:DIVISION"
    }, delimiter = ':')
    void successOf(String op, Operator expect) {
        // when
        Operator actual = Operator.of(op);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("of() 오류 검사")
    @ValueSource(strings = {
            "|", "(", "_", ","
    })
    void failOf(String op) {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> Operator.of(op));
    }

    @ParameterizedTest
    @DisplayName("isOperator() 성공 검사")
    @ValueSource(strings = {
            "+", "-", "*", "/"
    })
    void successIsOperator(String op) {
        // when
        boolean actual = Operator.isOperator(op);

        // then
        assertThat(actual).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("isOperator() 실패 검사")
    @ValueSource(strings = {
            "|", "(", "_", ","
    })
    void failIsOperator(String op) {
        // when
        boolean actual = Operator.isOperator(op);

        // then
        assertThat(actual).isEqualTo(false);
    }
}

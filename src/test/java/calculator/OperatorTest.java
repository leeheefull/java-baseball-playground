package calculator;

import calculator.entity.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class OperatorTest {

    @ParameterizedTest
    @DisplayName("of() 오류 검사")
    @ValueSource(strings = {
            "|", "(", "_", ","
    })
    void failOf(String op) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> Operator.of(op));
    }
}

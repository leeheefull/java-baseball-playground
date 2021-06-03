package unitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("요구사항 1")
    @Test
    void split() {
        String[] actual1 = "1,2".split(",");
        String[] actual2 = "1".split(",");

        assertThat(actual1).contains("1", "2");
        assertThat(actual2).containsExactly("1");
    }

    @DisplayName("요구사항 2")
    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3: 문자열의 위치 값이 벗어날 때, 예외처리(1)")
    @Test
    void charAt1() {
        String actual = "abc";
        int idx = 4;

        assertThatThrownBy(() -> actual.charAt(idx))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: " + idx + ", Size: " + actual.length());
    }

    @DisplayName("요구사항 3: 문자열의 위치 값이 벗어날 때, 예외처리(2)")
    @Test
    void charAt2() {
        String actual = "abc";
        int idx = 4;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> actual.charAt(idx))
                .withMessageMatching("Index: " + idx + ", Size: " + actual.length());
    }
}

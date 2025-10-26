package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @Test
    void 양의정수가_아니면_예외발생() {
        assertThatThrownBy(() -> Validator.checkNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 정수");
    }

    @Test
    void 숫자가_아니면_예외발생() {
        assertThatThrownBy(() -> Validator.checkNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로만 입력");
    }
}

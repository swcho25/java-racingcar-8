package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 랜덤값이_4이상이면_전진() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getValue()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_3이하면_정지() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getValue()).isEqualTo(0);
    }

    @Test
    void 이름이_비어있다면_예외발생() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어있는 값");
    }

    @Test
    void 이름이_5자초과하면_예외발생() {
        assertThatThrownBy(() -> new Car("asdfgj"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과");
    }
}

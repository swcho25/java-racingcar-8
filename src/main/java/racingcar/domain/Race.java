package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int count) {
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                car.move(randomNumber);
            }
        }
    }

    private void printRacing() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }
}

package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> play(int count) {
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                car.move(randomNumber);
            }
            printRacing();
        }
        return findWinner();
    }

    private void printRacing() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }

    private List<String> findWinner() {
        int maxValue = getMaxValue();
        List<String> winners = new ArrayList<>();

        for(Car car: cars) {
            if(car.getValue() == maxValue) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxValue() {
        int max = -1;
        for(Car car: cars) {
            if(car.getValue() > max) {
                max = car.getValue();
            }
        }
        return max;
    }
}

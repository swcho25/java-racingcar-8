package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void playOneRound() {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            car.move(random);
        }
    }

    public List<String> findWinner() {
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

    public List<Car> getCars() {
        return cars;
    }
}

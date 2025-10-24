package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
            printRacing();
        }
        List<String> winners = findWinner();
        printRacingResult(winners);
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

    private void printRacingResult(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}

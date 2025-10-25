package racingcar.Controller;

import racingcar.Validator;
import racingcar.View.View;
import racingcar.domain.Car;
import racingcar.domain.Race;
import java.util.Arrays;
import java.util.List;

public class RacingController {
    private final View view;

    public RacingController(View view) {
        this.view = view;
    }

    public void run() {
        String carNames = view.readCarNames();
        String number = view.readCount();
        view.printStartMessage();
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();
        int count = Validator.checkNumber(number);
        Race race = new Race(cars);
        for (int i = 0; i < count; i++) {
            race.playOneRound();
            view.printRaceProgress(race);
        }
        view.printWinners(race);
    }
}

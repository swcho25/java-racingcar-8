package racingcar.Controller;

import racingcar.Validator;
import racingcar.View.View;
import racingcar.domain.Car;
import racingcar.domain.Race;
import java.util.Arrays;
import java.util.List;

/**
 * 자동차 경주 프로그램을 제어하는 컨트롤러 클래스입니다.
 * View를 통해 입출력을 담당합니다.
 * 입력받은 데이터를 통해 Race 도메인을 생성 및 실행합니다.
 */
public class RacingController {
    private final View view;

    /**
     * View를 주입 받아 초기화합니다.
     * @param view 입출력을 담당하는 View 객체
     */
    public RacingController(View view) {
        this.view = view;
    }

    /**
     * 자동차 경주 프로그램의 실행 흐름을 제어합니다.
     * 1. 자동차 이름과 시도 횟수를 입력 받습니다.
     * 2. 입력 값을 검증하고 자동차 리스트를 생성합니다.
     * 3. 입력된 시도 횟수만큼 경주를 반복하며 진행 상황을 출력합니다.
     * 4. 경주가 끝나면 최종 우승자를 출력합니다.
     */
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

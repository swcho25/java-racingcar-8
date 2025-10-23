package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Race;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String participants = Console.readLine();
        List<Car> cars = Arrays.stream(participants.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String number = Console.readLine();
        int count = Integer.parseInt(number);

        Race race = new Race(cars);
        race.play(count);
    }
}

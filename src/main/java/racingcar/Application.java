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
        int count = checkNumber(number);

        System.out.println("\n실행 결과");
        Race race = new Race(cars);
        race.play(count);
    }

    private static int checkNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로만 입력해야 합니다.");
        }
    }
}

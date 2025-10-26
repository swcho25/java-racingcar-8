package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/** 경주 하나를 표현하는 도메인 클래스 */
public class Race {
    private final List<Car> cars;

    /**
     * 경주 기본 생성자입니다.
     * @param cars 자동차 객체 리스트
     */
    public Race(List<Car> cars) {
        this.cars = cars;
    }

    /** 경주를 한 차례 진행 */
    public void playOneRound() {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            car.move(random);
        }
    }

    /**
     * value 값이 가장 높은 자동차의 이름을 찾아 리스트를 만듭니다.
     * @return 우승자의 이름을 담은 리스트를 반환합니다.
     */
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

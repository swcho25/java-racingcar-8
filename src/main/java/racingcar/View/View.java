package racingcar.View;

import racingcar.domain.Car;
import racingcar.domain.Race;
import java.util.List;

/** 입출력을 담당하는 View 클래스 */
public class View {
    private static final String CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String START_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    private final InputView inputView;
    private final OutputView outputView;

    /**
     * 입력과 출력을 담당하는 View 객체를 초기화합니다.
     * @param inputView 입력을 담당하는 객체
     * @param outputView 출력을 담당하는 객체
     */
    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 사용자에게 자동차 이름 입력 요청을 한 후 그 값을 반환합니다.
     * @return 쉼표(,)로 구분된 자동차 이름 문자열
     */
    public String readCarNames() {
        outputView.print(CAR_NAME);
        return inputView.readString();
    }

    /**
     * 사용자에게 시도 횟수 입력 요청을 한 후 그 값을 반환
     * @return 시도 횟수 값이 담긴 문자열
     */
    public String readCount() {
        outputView.print(TRY_COUNT);
        return inputView.readString();
    }

    /** 경주 시작을 알리는 메시지 출력 */
    public void printStartMessage() {
        outputView.print(START_MESSAGE);
    }

    /**
     * 경주가 종료된 후 최종 우승자를 출력합니다.
     * @param race 경주 결과를 확인할 수 있는 경주 객체입니다.
     */
    public void printWinners(Race race) {
        List<String> winners = race.findWinner();
        System.out.println(WINNER_MESSAGE + String.join(", ", winners));
    }

    /**
     * 경주 진행 과정을 출력합니다.
     * @param race 경주 진행 상황을 확인할 수 있는 경주 객체입니다.
     */
    public void printRaceProgress(Race race) {
        for (Car car : race.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }
}

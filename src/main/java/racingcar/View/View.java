package racingcar.View;

import java.util.List;

public class View {
    private static final String CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String START_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String readCarNames() {
        outputView.print(CAR_NAME);
        return inputView.readString();
    }

    public String readCount() {
        outputView.print(TRY_COUNT);
        return inputView.readString();
    }

    public void printStartMessage() {
        outputView.print(START_MESSAGE);
    }

    public void printWinners(List<String> winners) {
        outputView.print(WINNER_MESSAGE + String.join(", ", winners));
    }
}

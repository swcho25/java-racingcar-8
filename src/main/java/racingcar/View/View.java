package racingcar.View;

import java.util.List;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String readCarNames() {
        outputView.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return inputView.readString();
    }

    public String readCount() {
        outputView.print("시도할 횟수는 몇 회인가요?");
        return inputView.readString();
    }

    public void printStartMessage() {
        outputView.print("\n실행 결과");
    }

    public void printWinners(List<String> winners) {
        outputView.print("최종 우승자 : " + String.join(", ", winners));
    }
}

package racingcar;

import racingcar.Controller.RacingController;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.View.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View(new InputView(), new OutputView());
        RacingController racingController = new RacingController(view);
        racingController.run();
    }
}

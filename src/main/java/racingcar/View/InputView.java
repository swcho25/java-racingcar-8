package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

/** 입력을 담당하는 View 클래스 */
public class InputView {

    /**
     * Console을 통해 사용자가 입력한 값을 반환합니다.
     * @return 입력 값을 반환합니다.
     */
    public String readString() {
        return Console.readLine();
    }
}

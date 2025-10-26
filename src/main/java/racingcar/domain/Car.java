package racingcar.domain;

/** 자동차 하나를 표현하는 도메인 클래스 */
public class Car {
    private static final String ERROR_EMPTY_NAME = "비어있는 값이 입력 되었습니다.";
    private static final String ERROR_NAME_TOO_LONG = "자동차 이름이 5자를 초과했습니다.";

    private final String name;
    private int value = 0;

    /**
     * 자동차 기본 생성자입니다.
     * @param name 자동차 이름
     * @throws IllegalArgumentException 이름이 비어 있거나 5자를 초과하는 경우
     */
    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name==null || name.isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
        if(name.length()>5) {
            throw new IllegalArgumentException(ERROR_NAME_TOO_LONG);
        }
    }

    /**
     * 무작위 값이 4 이상일 경우 자동차를 한 칸 전진시킵니다.
     * @param num 무작위 숫자 (0~9)
     */
    public void move(int num) {
        if(num>=4) {
            this.value++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}

package racingcar.domain;

public class Car {
    private static final String ERROR_EMPTY_NAME = "비어있는 값이 입력 되었습니다.";
    private static final String ERROR_NAME_TOO_LONG = "자동차 이름이 5자를 초과했습니다.";

    private final String name;
    private int value = 0;

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

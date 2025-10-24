package racingcar;

public class Validator {

    private Validator() {}

    public static int checkNumber(String input) {
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

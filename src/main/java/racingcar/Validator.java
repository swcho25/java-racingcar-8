package racingcar;

/** 입력 값 검증을 담당하는 클래스 */
public class Validator {
    private static final String ERROR_UP_NUMBER_ONE = "시도 횟수는 1 이상의 정수여야 합니다.";
    private static final String  ERROR_NOT_NUMBER = "시도 횟수는 숫자로만 입력해야 합니다.";

    private Validator() {}

    /**
     * 입력 값이 양의 정수인지 검증합니다.
     * @param input 사용자 입력 값
     * @return 검증 완료된 문자를 Integer로 형변환 해 반환
     * @throws IllegalArgumentException 잘못된 형식의 입력인 경우
     */
    public static int checkNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException(ERROR_UP_NUMBER_ONE);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }
}

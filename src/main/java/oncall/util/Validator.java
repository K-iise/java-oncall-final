package oncall.util;

public class Validator {
    // 1. 공통: 빈 값인지 확인
    private void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
    }

    // 2. 공통: 기본적인 쉼표 포맷 확인
    private void validateBasicCommaFormat(String input) {
        validateEmpty(input);
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
        if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
    }

    // 3. 월,요일 입력 전용 (쉼표로 나눴을 때 딱 2개여야 함)
    public void validateWorkInfoFormat(String input) {
        validateBasicCommaFormat(input);
        if (input.split(",").length != 2) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
    }

    // 4. 사원 리스트 입력 전용
    public void validateWorkTempleFormat(String input) {
        validateBasicCommaFormat(input);
        // 사원 리스트는 쉼표로 나눴을 때 개수가 유동적이므로
        // 기본적인 쉼표 포맷만 확인하고 통과!
    }

}

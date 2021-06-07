package baseball.exception;

public class ExitException extends RuntimeException {
    @Override
    public String getMessage() {
        return "프로그램을 종료하겠습니다.";
    }
}

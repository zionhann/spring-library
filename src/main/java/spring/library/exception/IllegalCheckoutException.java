package spring.library.exception;

public class IllegalCheckoutException extends RuntimeException {
  public IllegalCheckoutException() {
    super("최대 대출 가능 권수를 초과했습니다.");
  }
}

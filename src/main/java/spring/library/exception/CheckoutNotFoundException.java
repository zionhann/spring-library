package spring.library.exception;

public class CheckoutNotFoundException extends RuntimeException {
  public CheckoutNotFoundException() {
    super("해당하는 대출 정보를 찾을 수 없습니다.");
  }
}

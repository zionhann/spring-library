package spring.library.exception;

public class IllegalReturnException extends RuntimeException {
  public IllegalReturnException() {
    super("이미 반납된 도서입니다.");
  }
}

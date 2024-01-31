package spring.library.exception;

public class NoAvailableBookException extends RuntimeException {
  public NoAvailableBookException() {
    super("이미 대출중인 도서입니다.");
  }
}

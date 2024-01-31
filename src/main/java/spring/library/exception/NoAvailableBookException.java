package spring.library.exception;

public class NoAvailableBookException extends RuntimeException {
  public NoAvailableBookException() {
    super("대출 가능한 도서가 없습니다.");
  }
}

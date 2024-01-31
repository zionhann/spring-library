package spring.library.exception;

public class FeatureNotFoundException extends RuntimeException {
  public FeatureNotFoundException() {
    super("해당 회원 종류를 찾을 수 없습니다.");
  }
}

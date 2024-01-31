package spring.library.domain;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import spring.library.exception.FeatureNotFoundException;

@Getter
@RequiredArgsConstructor
public enum Feature {
  STUDENT("학생", 10),
  STAFF("교직원", 20),
  ADMIN("관리자", 110813);

  private final String kor;
  private final int maxCount;

  public static Feature findByName(String name) {
    return Arrays.stream(Feature.values())
        .filter(feat -> feat.kor.equals(name))
        .findFirst()
        .orElseThrow(FeatureNotFoundException::new);
  }

  public long getCheckoutDuration() {
    return maxCount;
  }
}

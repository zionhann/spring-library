package spring.library.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookRequest {

  private String title;
  private String author;
  private String publisher;
  private int publicationYear;
  private String classification;
}

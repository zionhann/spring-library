package spring.library.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.BookDto;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class BookResponse {

  private Long bookId;
  private String title;
  private String author;
  private String publisher;
  private int publicationYear;
  private String classification;
  private String status;

  public BookResponse(BookDto dto) {
    this.bookId = dto.getBookId();
    this.title = dto.getTitle();
    this.author = dto.getAuthor();
    this.publisher = dto.getPublisher();
    this.publicationYear = dto.getPublicationYear();
    this.classification = dto.getClassification();
    this.status = dto.getStatus();
  }
}

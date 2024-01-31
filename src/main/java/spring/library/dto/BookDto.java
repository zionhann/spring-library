package spring.library.dto;

import lombok.Builder;
import lombok.Getter;
import spring.library.controller.request.BookRequest;
import spring.library.domain.Book;

@Getter
@Builder
public class BookDto {

  private Long bookId;
  private String title;
  private String author;
  private String publisher;
  private int publicationYear;
  private String classification;
  private String status;

  public static BookDto of(BookRequest request) {
    return BookDto.builder()
        .title(request.getTitle())
        .author(request.getAuthor())
        .publisher(request.getPublisher())
        .publicationYear(request.getPublicationYear())
        .classification(request.getClassification())
        .build();
  }

  public static BookDto of(Book book) {
    return BookDto.builder()
        .bookId(book.getBookId())
        .title(book.getTitle())
        .author(book.getAuthor())
        .publisher(book.getPublisher())
        .publicationYear(book.getPublicationYear())
        .classification(book.getClassification())
        .status(book.getStatus())
        .build();
  }
}

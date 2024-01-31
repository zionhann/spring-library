package spring.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.BookDto;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookId;

  private String title;
  private String author;
  private String publisher;
  private int publicationYear;
  private String classification;
  private String status;

  public static Book create(BookDto dto) {
    return Book.builder()
        .title(dto.getTitle())
        .author(dto.getAuthor())
        .publisher(dto.getPublisher())
        .publicationYear(dto.getPublicationYear())
        .classification(dto.getClassification())
        .status("대출가능")
        .build();
  }

  public void update(BookDto dto) {
    this.bookId = dto.getBookId();
    this.title = dto.getTitle();
    this.author = dto.getAuthor();
    this.publisher = dto.getPublisher();
    this.publicationYear = dto.getPublicationYear();
    this.classification = dto.getClassification();
    this.status = dto.getStatus();
  }

  public boolean isNotAvailable() {
    return this.status.equals("대출중");
  }

  public void changeStatus(String status) {
    this.status = status;
  }
}

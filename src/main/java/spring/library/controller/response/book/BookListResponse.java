package spring.library.controller.response.book;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.BookDto;

@Getter
@NoArgsConstructor
public class BookListResponse {

  private List<BookResponse> books;

  public BookListResponse(List<BookDto> books) {
    this.books = books.stream().map(BookResponse::new).toList();
  }
}

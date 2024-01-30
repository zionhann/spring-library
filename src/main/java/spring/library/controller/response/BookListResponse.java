package spring.library.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.BookDto;

import java.util.List;


@Getter
@NoArgsConstructor
public class BookListResponse {

    private List<BookResponse> books;

    public BookListResponse(List<BookDto> books) {
        this.books = books.stream().map(BookResponse::new).toList();
    }
}

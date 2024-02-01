package spring.library.controller;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.BookRequest;
import spring.library.controller.response.book.BookListResponse;
import spring.library.dto.BookDto;
import spring.library.service.BookService;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping
  public ResponseEntity<Void> addBook(@RequestBody BookRequest request) {
    BookDto dto = BookDto.of(request);
    Long bookId = bookService.addBook(dto);

    URI uri = URI.create("/books/" + bookId);

    return ResponseEntity.created(uri).build();
  }

  @GetMapping
  public ResponseEntity<BookListResponse> getAllBooks() {
    List<BookDto> books = bookService.getAllBooks();
    BookListResponse response = new BookListResponse(books);

    return ResponseEntity.ok(response);
  }

  @PatchMapping("/{bookId}")
  public ResponseEntity<Void> editBook(
      @PathVariable Long bookId, @RequestBody BookRequest request) {
    BookDto dto = BookDto.of(request);
    bookService.editBook(dto, bookId);

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{bookId}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
    bookService.deleteBook(bookId);
    return ResponseEntity.ok().build();
  }
}

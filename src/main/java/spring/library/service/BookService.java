package spring.library.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.library.domain.Book;
import spring.library.dto.BookDto;
import spring.library.exception.BookNotFoundException;
import spring.library.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public Long addBook(BookDto dto) {
    Book book = Book.create(dto);
    Book saved = bookRepository.save(book);

    return saved.getBookId();
  }

  public List<BookDto> getAllBooks() {
    List<Book> books = bookRepository.findAll();
    return books.stream().map(BookDto::of).toList();
  }

  @Transactional
  public void editBook(BookDto bookDto, Long bookId) {
    Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    book.update(bookDto);
  }

  public void deleteBook(Long bookId) {
    bookRepository.deleteById(bookId);
  }
}

package spring.library.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.library.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}

package spring.library.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.exception.IllegalReturnException;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long checkoutId;

  private LocalDateTime checkoutDate;
  private LocalDateTime dueDate;
  private LocalDateTime returnDate;
  private boolean isReturned;
  private boolean isRenewed;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")
  private Book book;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  public static Checkout create(Member member, Book book) {
    return Checkout.builder()
        .member(member)
        .book(book)
        .checkoutDate(LocalDateTime.now())
        .dueDate(LocalDateTime.now().plusDays(member.getCheckoutDuration()))
        .isReturned(false)
        .isRenewed(false)
        .build();
  }

  public void returnBook() {
    if (isReturned()) {
      throw new IllegalReturnException();
    }
    this.isReturned = true;
    this.returnDate = LocalDateTime.now();
    this.book.changeStatus("대출가능");
  }
}

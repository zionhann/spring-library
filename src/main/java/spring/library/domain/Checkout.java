package spring.library.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.exception.IllegalRenewalException;
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

  public void renewBook() {
    validateRenewal();
    this.isRenewed = true;
    this.dueDate = LocalDateTime.now().plusDays(5);
  }

  private void validateRenewal() {
    if (isRenewed) {
      throw new IllegalRenewalException("연장 가능 횟수를 초과했습니다.");
    } else if (isOverdue()) {
      throw new IllegalRenewalException("연체 중인 도서는 연장할 수 없습니다.");
    } else if (isNotDueDate()) {
      throw new IllegalRenewalException("도서 연장은 반납 예정일 당일에만 가능합니다.");
    }
  }

  private boolean isNotDueDate() {
    return LocalDate.now().isBefore(dueDate.toLocalDate());
  }

  private boolean isOverdue() {
    return LocalDate.now().isAfter(dueDate.toLocalDate());
  }
}

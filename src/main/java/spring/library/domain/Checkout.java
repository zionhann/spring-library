package spring.library.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
  private boolean isReturned;
  private boolean isRenewed;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  public static Checkout create(Member member, Book book) {
    return Checkout.builder()
        .member(member)
        .book(book)
        .checkoutDate(LocalDateTime.now())
        .dueDate(LocalDateTime.now().plusDays(10))
        .isReturned(false)
        .isRenewed(false)
        .build();
  }
}

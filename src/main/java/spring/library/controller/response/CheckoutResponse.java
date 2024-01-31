package spring.library.controller.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.domain.Checkout;

@Getter
@NoArgsConstructor
public class CheckoutResponse {
  private Long checkOutId;
  private String author;
  private String checkOutDate;
  private String dueDate;
  private int renewalCount;
  private Boolean isReturned;

  public CheckoutResponse(Checkout checkout) {
    this.checkOutId = checkout.getCheckoutId();
    this.author = checkout.getBook().getAuthor();
    this.checkOutDate = formatDateTime(checkout.getCheckoutDate());
    this.dueDate = formatDateTime(checkout.getDueDate());
    this.renewalCount = getRenewalCount(checkout);
    this.isReturned = checkout.isReturned();
  }

  private String formatDateTime(LocalDateTime dateTime) {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dateTime);
  }

  private int getRenewalCount(Checkout checkout) {
    if (checkout.isRenewed()) {
      return 1;
    }
    return 0;
  }
}

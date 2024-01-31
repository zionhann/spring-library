package spring.library.controller.response.checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.domain.Checkout;

@Getter
@NoArgsConstructor
public class OverallCheckoutResponse extends CheckoutResponse {
  private Long checkOutId;
  private String title;
  private String author;
  private String checkOutDate;
  private String dueDate;
  private int renewalCount;
  private Boolean isReturned;

  public OverallCheckoutResponse(Checkout checkout) {
    this.checkOutId = checkout.getCheckoutId();
    this.title = checkout.getBook().getTitle();
    this.author = checkout.getBook().getAuthor();
    this.checkOutDate = formatDateTime(checkout.getCheckoutDate());
    this.dueDate = formatDateTime(checkout.getDueDate());
    this.renewalCount = countRenewal(checkout);
    this.isReturned = checkout.isReturned();
  }
}

package spring.library.controller.response.checkout;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import spring.library.domain.Checkout;

public abstract class CheckoutResponse {

  protected String formatDateTime(LocalDateTime dateTime) {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dateTime);
  }

  protected int countRenewal(Checkout checkout) {
    if (checkout.isRenewed()) {
      return 1;
    }
    return 0;
  }
}

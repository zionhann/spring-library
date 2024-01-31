package spring.library.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import spring.library.domain.Checkout;

@Getter
@Builder
public class CheckoutDto {

  private Long checkoutId;
  private LocalDateTime checkoutDate;
  private LocalDateTime dueDate;
  private boolean isReturned;
  private boolean isRenewed;

  public static CheckoutDto of(Checkout checkout) {
    return CheckoutDto.builder()
        .checkoutId(checkout.getCheckoutId())
        .checkoutDate(checkout.getCheckoutDate())
        .dueDate(checkout.getDueDate())
        .isReturned(checkout.isReturned())
        .isRenewed(checkout.isRenewed())
        .build();
  }
}

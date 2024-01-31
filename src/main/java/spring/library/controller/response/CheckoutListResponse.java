package spring.library.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.domain.Checkout;

import java.util.List;

@Getter
@NoArgsConstructor
public class CheckoutListResponse {
  private List<CheckoutResponse> books;

  public CheckoutListResponse(List<Checkout> checkouts) {
    this.books = checkouts.stream().map(CheckoutResponse::new).toList();
  }
}

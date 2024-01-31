package spring.library.controller.response.checkout;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckoutListResponse {
  private List<CheckoutResponse> books;

  public CheckoutListResponse(List<CheckoutResponse> books) {
    this.books = books;
  }
}

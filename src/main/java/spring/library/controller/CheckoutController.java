package spring.library.controller;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.MemberRequest;
import spring.library.controller.response.CheckoutListResponse;
import spring.library.domain.Checkout;
import spring.library.service.CheckoutService;

@RestController
@RequestMapping("/checkouts")
@RequiredArgsConstructor
public class CheckoutController {

  private final CheckoutService checkoutService;

  @PostMapping("/{bookId}")
  public ResponseEntity<Void> checkoutBook(
      @PathVariable Long bookId, @RequestBody MemberRequest.IdOnly request) {
    Long checkoutId = checkoutService.checkoutBook(bookId, request.getMemberId());
    URI uri = URI.create("/checkouts/" + checkoutId);

    return ResponseEntity.created(uri).build();
  }

  @GetMapping
  public ResponseEntity<CheckoutListResponse> getCheckouts(@RequestParam Long memberId) {
    List<Checkout> checkouts = checkoutService.getCheckoutsOf(memberId);
    CheckoutListResponse res = new CheckoutListResponse(checkouts);

    return ResponseEntity.ok(res);
  }
}

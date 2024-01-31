package spring.library.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.domain.Book;
import spring.library.domain.Checkout;
import spring.library.domain.Member;
import spring.library.exception.BookNotFoundException;
import spring.library.exception.MemberNotFoundException;
import spring.library.repository.BookRepository;
import spring.library.repository.CheckoutRepository;
import spring.library.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class CheckoutService {

  private final BookRepository bookRepository;
  private final MemberRepository memberRepository;
  private final CheckoutRepository checkoutRepository;

  public Long checkoutBook(Long bookId, Long memberId) {
    Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
    Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);

    Checkout checkout = member.checkout(book);
    checkoutRepository.save(checkout);

    return checkout.getCheckoutId();
  }

  public List<Checkout> getCheckoutsOf(Long memberId) {
    Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
    return checkoutRepository.findAllByMemberAndReturned(member, false);
  }

  public List<Checkout> getCheckoutHistoryOf(Long memberId) {
    Member member =
        memberRepository
            .findAllByIdWithCheckouts(memberId)
            .orElseThrow(MemberNotFoundException::new);

    return member.getCheckouts();
  }
}

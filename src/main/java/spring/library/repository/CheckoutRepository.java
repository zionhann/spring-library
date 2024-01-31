package spring.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.library.domain.Checkout;
import spring.library.domain.Member;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    List<Checkout> findAllByMember(Member member);
}

package spring.library.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.library.domain.Checkout;
import spring.library.domain.Member;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
  List<Checkout> findAllByMember(Member member);

  @Query(
      "select c from Checkout c join fetch c.book where c.member = :member and c.isReturned = :isReturned")
  List<Checkout> findAllByMemberAndReturned(Member member, boolean isReturned);
}

package spring.library.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.library.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  @Query("select m from Member m join fetch m.checkouts where m.memberId = :memberId")
  Optional<Member> findAllByIdWithCheckouts(Long memberId);
}

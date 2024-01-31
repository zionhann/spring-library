package spring.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.library.domain.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {}

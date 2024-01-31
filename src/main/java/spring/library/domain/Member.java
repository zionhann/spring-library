package spring.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import spring.library.dto.MemberDto;
import spring.library.exception.NoAvailableBookException;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  private String name;
  private int idNumber;
  private String feature;
  private String email;
  private String phoneNumber;

  public static Member create(MemberDto dto) {
    return Member.builder()
        .name(dto.getName())
        .idNumber(dto.getIdNumber())
        .feature(dto.getFeature())
        .email(dto.getEmail())
        .phoneNumber(dto.getPhoneNumber())
        .build();
  }

  public Checkout checkout(Book book) {
    if (book.isNotAvailable()) {
      throw new NoAvailableBookException();
    }
    book.changeStatus("대출중");
    return Checkout.create(this, book);
  }
}

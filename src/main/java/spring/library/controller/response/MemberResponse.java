package spring.library.controller.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.MemberDto;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberResponse {
    private Long memberId;
    private String name;
    private int idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public MemberResponse(MemberDto dto) {
        this.memberId = dto.getMemberId();
        this.name = dto.getName();
        this.idNumber = dto.getIdNumber();
        this.feature = dto.getFeature();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
    }
}

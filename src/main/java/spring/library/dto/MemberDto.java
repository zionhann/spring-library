package spring.library.dto;

import lombok.Builder;
import lombok.Getter;
import spring.library.controller.request.MemberRequest;
import spring.library.domain.Member;

@Builder
@Getter
public class MemberDto {

    private Long memberId;
    private String name;
    private int idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public static MemberDto of(MemberRequest request) {
        return MemberDto.builder()
                .name(request.getName())
                .idNumber(request.getIdNumber())
                .feature(request.getFeature())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public static MemberDto of(Member member) {
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .idNumber(member.getIdNumber())
                .feature(member.getFeature())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}

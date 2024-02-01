package spring.library.controller.response.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.MemberDto;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class MemberListResponse {
  private List<MemberResponse> members;

  public MemberListResponse(List<MemberDto> members) {
    this.members = members.stream().map(MemberResponse::new).toList();
  }
}

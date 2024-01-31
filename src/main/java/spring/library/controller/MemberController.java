package spring.library.controller;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.MemberRequest;
import spring.library.controller.response.MemberListResponse;
import spring.library.dto.MemberDto;
import spring.library.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

  private final MemberService memberService;

  @PostMapping
  public ResponseEntity<Void> addMember(@RequestBody MemberRequest request) {
    MemberDto dto = MemberDto.of(request);
    Long memberId = memberService.addMember(dto);
    URI uri = URI.create("/members/" + memberId);

    return ResponseEntity.created(uri).build();
  }

  @GetMapping
  public ResponseEntity<MemberListResponse> getAllMembers() {
    List<MemberDto> members = memberService.getAllMembers();
    MemberListResponse response = new MemberListResponse(members);

    return ResponseEntity.ok(response);
  }

  @PutMapping("/{memberId}")
  public ResponseEntity<Void> editMember(
      @PathVariable Long memberId, @RequestBody MemberRequest request) {
    MemberDto dto = MemberDto.of(request);
    memberService.editMember(dto, memberId);

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{memberId}")
  public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
    memberService.delete(memberId);

    return ResponseEntity.ok().build();
  }
}

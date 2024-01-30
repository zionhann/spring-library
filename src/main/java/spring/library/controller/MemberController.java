package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.MemberRequest;
import spring.library.controller.response.MemberListResponse;
import spring.library.dto.MemberDto;
import spring.library.service.MemberService;

import java.net.URI;
import java.util.List;

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
}

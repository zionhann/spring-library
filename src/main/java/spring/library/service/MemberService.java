package spring.library.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.library.domain.Member;
import spring.library.dto.MemberDto;
import spring.library.exception.MemberNotFoundException;
import spring.library.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public Long addMember(MemberDto dto) {
    Member member = Member.create(dto);
    Member saved = memberRepository.save(member);

    return saved.getMemberId();
  }

  public List<MemberDto> getAllMembers() {
    List<Member> members = memberRepository.findAll();
    return members.stream().map(MemberDto::of).toList();
  }

  @Transactional
  public void editMember(MemberDto dto, Long memberId) {
    Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
    member.update(dto);
  }

  public void delete(Long memberId) {
    memberRepository.deleteById(memberId);
  }
}

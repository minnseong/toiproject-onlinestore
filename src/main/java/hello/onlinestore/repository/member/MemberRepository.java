package hello.onlinestore.repository.member;

import hello.onlinestore.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByUserId(String userId);
    List<Member> findAll();
    void clear();
}

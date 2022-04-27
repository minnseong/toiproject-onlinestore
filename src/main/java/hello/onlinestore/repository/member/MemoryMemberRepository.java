package hello.onlinestore.repository.member;

import hello.onlinestore.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> repository = new HashMap<>();
    private static long seq = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++seq);
        repository.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        return repository.values().stream()
                .filter(member -> member.getUserId().equals(userId))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public void clear() {
        repository.clear();
    }
}

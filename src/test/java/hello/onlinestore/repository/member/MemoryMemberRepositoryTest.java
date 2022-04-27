package hello.onlinestore.repository.member;

import hello.onlinestore.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clear();
    }

    @Test
    void saveAndFindById() {
        Member member = new Member("username", "userId", "1234", "user@com", "000-000");
        repository.save(member);

        Member findMember = repository.findById(member.getId()).get();
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findByUserId() {
        Member member1 = new Member("username1", "userId1", "1234", "user@com", "000-000");
        Member member2 = new Member("username2", "userId2", "1234", "user@com", "000-000");
        repository.save(member1);
        repository.save(member2);

        Member member = repository.findByUserId("userId1").get();
        assertThat(member).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member("username1", "userId1", "1234", "user@com", "000-000");
        Member member2 = new Member("username2", "userId2", "1234", "user@com", "000-000");
        repository.save(member1);
        repository.save(member2);

        List<Member> memberList = repository.findAll();
        assertThat(memberList.size()).isEqualTo(2);
    }
}
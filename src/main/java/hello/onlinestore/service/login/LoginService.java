package hello.onlinestore.service.login;

import hello.onlinestore.domain.member.Member;
import hello.onlinestore.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String userId, String password) {
        log.info("userId : {}", userId);
        log.info("password : {}", password);
        return memberRepository.findByUserId(userId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }

}

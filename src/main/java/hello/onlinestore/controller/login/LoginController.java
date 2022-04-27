package hello.onlinestore.controller.login;

import hello.onlinestore.domain.member.LoginForm;
import hello.onlinestore.domain.member.Member;
import hello.onlinestore.repository.member.MemberRepository;
import hello.onlinestore.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberRepository repository;
    private final LoginService loginService;

    @GetMapping("/")
    public String home(@ModelAttribute LoginForm loginForm) {
        return "home";
    }

    @PostMapping("/")
    public String login(@ModelAttribute LoginForm loginForm) {
        if (loginService.login(loginForm.getUserId(), loginForm.getPassword()) == null)
            return "redirect:/";
        else {
            return "redirect:/asd";
        }
    }

    @GetMapping("/members/add")
    public String registerForm(@ModelAttribute Member member) {
        return "login/registerForm";
    }

    @PostMapping("/members/add")
    public String register(@ModelAttribute Member member) {
        repository.save(member);
        return "redirect:/";
    }
}

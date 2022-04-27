package hello.onlinestore.domain.member;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private String name;
    private String userId;
    private String password;
    private String email;
    private String phoneNumber;

    public Member(String name, String userId, String password, String email, String phoneNumber) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

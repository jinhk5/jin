package myCat.cat.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myCat.cat.domain.User;
import myCat.cat.domain.UserRole;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserForm {

    @NotEmpty(message = "아이디를 입력하세요")
    private String loginId;

    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String password;
    private String passwordCheck;

    @NotEmpty(message = "이름을 입력하세요")
    private String name;

    private String email;
    private String nickname;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .loginId(this.loginId)
                .password(encodedPassword)
                .nickname(this.nickname)
                .name(this.name)
                .email(this.email)
                .role(UserRole.USER)
                .registerDate(LocalDateTime.now())
                .build();
    }



}

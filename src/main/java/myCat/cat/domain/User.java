package myCat.cat.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String loginId;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String email;

    private String nickname;

    private String provider;

    private String providerId;

    private int socialCode;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private List<Cat> myCats = new ArrayList<>();

    public User(String loginId, String name, String email, String nickname) {
        this.loginId = loginId;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.registerDate = LocalDateTime.now();
    }

    public void update(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
        this.updateDate = LocalDateTime.now();
    }

}

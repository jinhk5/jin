package myCat.cat.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String loginId;

    private String name;

    private String email;

    private String nickname;

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

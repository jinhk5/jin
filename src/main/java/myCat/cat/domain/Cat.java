package myCat.cat.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cat {

    @Id @GeneratedValue
    @Column(name = "cat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    private String profile;

    private String type;

    private int gender;

    private String birthdate;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public Cat(User user, String name, String profile, String type, int gender, String birthdate) {
        this.user = user;
        this.name = name;
        this.profile = profile;
        this.type = type;
        this.gender = gender;
        this.birthdate = birthdate;
        this.registerDate = LocalDateTime.now();
    }

    public void update(String name, String profile, String type, int gender, String birthdate) {
        this.name = name;
        this.profile = profile;
        this.type = type;
        this.gender = gender;
        this.birthdate = birthdate;
        this.updateDate = LocalDateTime.now();
    }
}

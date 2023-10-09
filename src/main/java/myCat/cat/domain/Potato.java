package myCat.cat.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Potato {

    @Id @GeneratedValue
    @Column(name = "potato_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    private LocalDate date;

    private String time;

    @Enumerated(EnumType.STRING)
    private PotatoStatus potatoStatus;

    @Embedded
    private Base base;
}

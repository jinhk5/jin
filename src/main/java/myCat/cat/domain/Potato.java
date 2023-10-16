package myCat.cat.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Potato extends Base{

    @Id @GeneratedValue
    @Column(name = "potato_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private CatRecord catRecord;

    private LocalDate date;

    private String time;

    @Enumerated(EnumType.STRING)
    private PotatoStatus potatoStatus;


}

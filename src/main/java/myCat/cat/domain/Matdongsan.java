package myCat.cat.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Matdongsan {

    @Id @GeneratedValue
    @Column(name = "mds_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    private String date;

    private String time;

    @Enumerated(EnumType.STRING)
    private MdsStatus status;

    private int cntPerTime;

    @Embedded
    private Base base;

    public void setCat(Cat cat) {
        this.cat = cat;
    }

}

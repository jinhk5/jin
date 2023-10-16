package myCat.cat.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Matdongsan extends Base{

    @Id @GeneratedValue
    @Column(name = "mds_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private CatRecord catRecord;

    private String date;

    private String time;

    @Enumerated(EnumType.STRING)
    private MdsStatus status;

    private int cntPerTime;


    public void setCat(CatRecord catRecord) {
        this.catRecord = catRecord;
    }

}

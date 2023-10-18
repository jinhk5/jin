package myCat.cat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
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

    public Matdongsan(CatRecord catRecord, String date, String time, MdsStatus status, int cntPerTime) {
        this.catRecord = catRecord;
        this.date = date;
        this.time = time;
        this.status = status;
        this.cntPerTime = cntPerTime;
    }

    public void update(String time, MdsStatus status, int cntPerTime) {
        this.time = time;
        this.status = status;
        this.cntPerTime = cntPerTime;
    }




}

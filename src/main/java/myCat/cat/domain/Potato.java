package myCat.cat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Potato extends Base{

    @Id @GeneratedValue
    @Column(name = "potato_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private CatRecord catRecord;

    private String date;

    private String time;

    @Enumerated(EnumType.STRING)
    private PotatoStatus potatoStatus;

    public Potato(CatRecord catRecord, String date, String time, PotatoStatus potatoStatus) {
        this.catRecord = catRecord;
        this.date = date;
        this.time = time;
        this.potatoStatus = potatoStatus;
    }

    public void update(String time, PotatoStatus potatoStatus) {
        this.time = time;
        this.potatoStatus = potatoStatus;
    }


}

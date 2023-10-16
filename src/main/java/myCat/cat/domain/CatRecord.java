package myCat.cat.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CatRecord extends Base{

    @Id @GeneratedValue
    @Column(name = "record_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    private String date;

    @Enumerated(EnumType.STRING)
    private RecordType recordType;

    public CatRecord(Cat cat, String date, RecordType recordType, User user) {
        this.cat = cat;
        this.date = date;
        this.recordType = recordType;
    }


}

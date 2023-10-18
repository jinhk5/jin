package myCat.cat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class MedicationManage extends Base{

    @Id @GeneratedValue
    @Column(name = "mm_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    private String medName;

    public MedicationManage(Cat cat, String medName) {
        this.cat = cat;
        this.medName = medName;
    }

    public void update(String medName) {
        this.medName = medName;
    }


}

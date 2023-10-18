package myCat.cat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Medication extends Base{

    @Id @GeneratedValue
    @Column(name = "med_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mm_id")
    private MedicationManage medicationManage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private CatRecord catRecord;

    public Medication(CatRecord catRecord, MedicationManage medicationManage) {
        this.catRecord = catRecord;
        this.medicationManage = medicationManage;
    }

    public void update(MedicationManage medicationManage) {
        this.medicationManage = medicationManage;
    }





}

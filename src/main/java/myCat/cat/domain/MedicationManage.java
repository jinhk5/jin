package myCat.cat.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class MedicationManage {

    @Id @GeneratedValue
    @Column(name = "mm_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    private LocalDate date;

    @Embedded
    private Base base;
}

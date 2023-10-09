package myCat.cat.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Embeddable
public class Base {

    private Long registBy;

    private LocalDateTime registerDate;

    private Long updateBy;

    private LocalDateTime updateDate;

    private String deleteYn;

    private Long deleteBy;

    private LocalDateTime deleteDate;

}

package myCat.cat.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {

    @CreatedBy
    @Column(updatable = false)
    private Long registBy;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime registerDate;

    @LastModifiedBy
    private Long updateBy;

    @LastModifiedDate
    private LocalDateTime updateDate;

    private String deleteYn = "N";

    private Long deleteBy;

    private LocalDateTime deleteDate;

}

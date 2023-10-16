package myCat.cat.domain;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Getter
public class Diary extends Base{

    @Id @GeneratedValue
    @Column(name = "diary_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @Lob
    @Column(name = "contents", columnDefinition = "BLOB")
    private byte[] contents;

    private String mediaContents;



}

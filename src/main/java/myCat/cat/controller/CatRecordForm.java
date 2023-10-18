package myCat.cat.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myCat.cat.domain.MdsStatus;
import myCat.cat.domain.MedicationManage;
import myCat.cat.domain.PotatoStatus;
import myCat.cat.domain.RecordType;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CatRecordForm {

    @NotEmpty(message = "종류를 선택하세요.")
    private RecordType recordType;

    private String date;

    private String time;

    private MdsStatus mdsStatus;

    private int cntPerTime;

    private PotatoStatus potatoStatus;

    private MedicationManage medicationManage;





}

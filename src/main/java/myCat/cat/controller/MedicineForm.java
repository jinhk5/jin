package myCat.cat.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MedicineForm {

    @NotEmpty(message = "이름을 입력하세요.")
    private String medicineName;
}

package myCat.cat.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CatForm {

    @NotEmpty(message = "name required")
    private String name;
    private String profile;
    private String birthDate;
    private String type;
    private int gender;
}

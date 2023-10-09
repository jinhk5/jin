package myCat.cat.controller;

import lombok.RequiredArgsConstructor;
import myCat.cat.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("/cats/new")
    public String createForm(Model model) {
        model.addAttribute("form", new CatForm());
        return "cat/createCatForm";
    }

//    @PostMapping("/cats/new")
//    public String create(@ModelAttribute("form") CatForm form) {
//        catService.registerCat();
//    }
}

package myCat.cat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        log.info("home controller");
        model.addAttribute("recordForm", new CatRecordForm());
        return "home2";
    }
}

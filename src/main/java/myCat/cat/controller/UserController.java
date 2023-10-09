package myCat.cat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myCat.cat.domain.User;
import myCat.cat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/users/new")
    public String createForm(Model model) {
        model.addAttribute("form", new UserForm());
        return "users/createUserForm";
    }

    @PostMapping("/users/new")
    public String create(@ModelAttribute("form") UserForm form) {
        log.info("create Post");
        userService.registerUser(form);
        return "redirect:/";
    }

    @GetMapping("/users/{userId}/edit")
    public String updateUserInfo(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("form", userService.findOne(userId));
        return "users/updateUserForm";
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable("userId") Long userId, @ModelAttribute("form") UserForm form) {
        userService.updateUser(userId, form);

        return "redirect:/";
    }
}

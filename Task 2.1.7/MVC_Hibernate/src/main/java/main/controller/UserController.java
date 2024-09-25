package main.controller;

import main.model.User;
import main.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    showAllUsers
    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";

    }

    //adduser
    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }


    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    //info
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userInfo";
    }
    //editUser
    @GetMapping(value = "/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
    //deleteuser
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}

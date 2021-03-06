package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.Service;

import javax.annotation.PostConstruct;


@Controller
@RequestMapping("/users")
public class UserController {

    @PostConstruct
    public void loadTestUser() {

        User user1 = new User("Ivan", "Ivanov", (byte) 20);
        User user2 = new User("Andrei", "Andreev", (byte) 21);
        User user3 = new User("Kolia", "Nikolaev", (byte) 22);
        User user4 = new User("Petr", "Petrov", (byte) 23);

        service.addUser(user1);
        service.addUser(user2);
        service.addUser(user3);
        service.addUser(user4);
    }

    private Service service;

    @Autowired
    public UserController(Service service) {
        this.service = service;
    }

    @GetMapping()
    public String allUsers(ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "users/all";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", service.getUserById(id));
        return "users/show";
    }

    @GetMapping(value = "/new")
    public String add(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") int id) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PutMapping(value = "{id}")
    public String edit(@ModelAttribute("user") User user) {
        service.upDateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteUser(id);
        return "redirect:/users";
    }

}
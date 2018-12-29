package ua.com.owu.spring_boot_third_try.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.owu.spring_boot_third_try.dao.UserDAO;
import ua.com.owu.spring_boot_third_try.models.Email;
import ua.com.owu.spring_boot_third_try.models.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "index";
    }

    @Autowired
    private UserDAO userDAO;

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam String username, Model model, @RequestParam String email) {

        User user = new User();
        user.setName(username);

        List<Email> emails = new ArrayList<>();
        Email email1 = new Email();
        email1.setEmail(email);
        email1.setUser(user);
        emails.add(email1);

        user.setEmails(emails);

        userDAO.save(user);


        System.out.println(user);

        model.addAttribute("allUsers", userDAO.findAll());

        return "userSaveDone";
    }

    @GetMapping("/user-{id}")
    public String singleUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("currentUser", userDAO.findById(id).get());
        return "singleUser";
    }
}

package com.example.cmpt276project.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.cmpt276project.models.User;
import com.example.cmpt276project.models.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "users/add";
    }

    @PostMapping("users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response, Model model) {
        String newName = newuser.get("name");
        String newPwd = newuser.get("password");

        // Check if the username already exists in the database if yes bring to another
        // page
        List<User> existingUsers = userRepo.findByName(newName);
        if (!existingUsers.isEmpty()) {
            return "users/usertaken";
        }

        // Save the new user to the database
        userRepo.save(new User(newName, newPwd));
        response.setStatus(201);
        model.addAttribute("name", newName);
        return "users/addedUser";
    }

    @GetMapping("/view")
    public String getAllUsers(Model model) {
        System.out.println("Getting all users");
        // get all users from database
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "users/showAll";
    }

    @GetMapping("/")
    public RedirectView process() {
        return new RedirectView("login");
    }

    @GetMapping("/login")
    public String getLogin(Model model, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return "users/login";
        } else {
            model.addAttribute("user", user);
            return "redirect:/protected";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> formData, Model model, HttpServletRequest request,
            HttpSession session) {
        String name = formData.get("name");
        String password = formData.get("password");
        List<User> users = userRepo.findByNameAndPassword(name, password);
        if (users.isEmpty()) {
            model.addAttribute("loginError", true);
            return "users/login";
        } else {
            User user = users.get(0);
            request.getSession().setAttribute("session_user", user);
            return "redirect:/protected";
        }
    }

    @GetMapping("/protected")
    public String protectedPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("user", user);
            return "users/protected";
        }
    }

    @GetMapping("/logout")
    public String destroySession(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (session != null) {
            // Disable caching
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            request.getSession().removeAttribute("session_user");
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/availability")
    public String timetable(Model model, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("user", user);
            return "users/availability";
        }
    }

    @GetMapping("/course1")
    public String course1(Model model, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("user", user);
            return "users/course1";
        }
    }

}

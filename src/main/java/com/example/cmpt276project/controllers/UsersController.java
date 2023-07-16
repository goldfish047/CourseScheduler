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
    
    // Check if the username already exists in the database if yes bring to another page
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
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        // get all users from database
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "users/showAll";
    }

    @GetMapping("/")
    public RedirectView process(){
        return new RedirectView("login");
    }

    @GetMapping("/login")
    public String getLogin(Model model, HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("session_user");
        if (user == null){
            return "users/login";
        }
        else {
            model.addAttribute("user",user);
            return "users/protected";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String,String> formData, Model model, HttpServletRequest request, HttpSession session){
        // processing login
        String name = formData.get("name");
        String pwd = formData.get("password");
        List<User> userlist = userRepo.findByNameAndPassword(name, pwd);
        if (userlist.isEmpty()){
            return "users/loginfailed";
        }
        else {
            // success
            User user = userlist.get(0);
            request.getSession().setAttribute("session_user", user);
            model.addAttribute("user", user);
            return "users/protected";
        }
    }

    @GetMapping("/logout")
    public String destroySession(HttpServletRequest request){
        request.getSession().invalidate();
        return "users/login";
    }

    @GetMapping("/timetable")
    public String timetable() {
        return "users/timetable";
    }
    
}

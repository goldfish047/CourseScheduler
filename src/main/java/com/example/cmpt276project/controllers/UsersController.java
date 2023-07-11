package com.example.cmpt276project.controllers;

<<<<<<< HEAD
<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
=======
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
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
<<<<<<< HEAD
<<<<<<< HEAD
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.calendar.CalendarScopes;
=======
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

<<<<<<< HEAD
<<<<<<< HEAD

import com.google.api.client.json.JsonFactory;

import com.google.api.client.json.gson.GsonFactory;


import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.util.Collections;




@Controller
public class UsersController {


    @Autowired
    private UserRepository userRepo;

    // Update the following constants with your application name and credentials file path
    private static final String APPLICATION_NAME = "Your Application Name";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "client_secret.json"; // Replace with the actual path to your credentials JSON file

    private Calendar getCalendarService() throws IOException, GeneralSecurityException {
        InputStream credentialsInputStream = getClass().getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsInputStream)
                .createScoped(Collections.singleton(CalendarScopes.CALENDAR));
        credentials.refreshIfExpired();
        HttpCredentialsAdapter credentialsAdapter = new HttpCredentialsAdapter(credentials);

        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Calendar.Builder(httpTransport, JSON_FACTORY, credentialsAdapter)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    @GetMapping("/calendar")
public String showCalendar(Model model) {
    try {
        Calendar calendarService = getCalendarService();
        String calendarId = "primary"; // Use "primary" for the primary calendar associated with the authenticated user
        Events events = calendarService.events().list(calendarId).execute();
        List<Event> eventList = events.getItems();

        model.addAttribute("events", eventList);
        return "users/calendar";
    } catch (IOException | GeneralSecurityException e) {
        e.printStackTrace();
        // Handle the exception appropriately
        // For example, you can show an error message to the user or redirect to an error page
        return "error";
    }
}


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
=======
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
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
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response, Model model){
        System.out.println("ADD user");
        String newName = newuser.get("name");
        String newPwd = newuser.get("password");
        userRepo.save(new User(newName,newPwd));
        response.setStatus(201);
        model.addAttribute("name", newName); ;
<<<<<<< HEAD
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
        return "users/addedUser";
    }

    @GetMapping("/view")
<<<<<<< HEAD
<<<<<<< HEAD
    public String getAllUsers(Model model) {
=======
    public String getAllUsers(Model model){
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
    public String getAllUsers(Model model){
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
        System.out.println("Getting all users");
        // get all users from database
        List<User> users = userRepo.findAll();
        // end of database call
        model.addAttribute("us", users);
        return "users/showAll";
    }

    @GetMapping("/")
<<<<<<< HEAD
<<<<<<< HEAD
    public RedirectView process() {
=======
    public RedirectView process(){
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
    public RedirectView process(){
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
        return new RedirectView("login");
    }

    @GetMapping("/login")
<<<<<<< HEAD
<<<<<<< HEAD
    public String getLogin(Model model, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return "users/login";
        } else {
            model.addAttribute("user", user);
=======
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
    public String getLogin(Model model, HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("session_user");
        if (user == null){
            return "users/login";
        }
        else {
            model.addAttribute("user",user);
<<<<<<< HEAD
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
            return "users/protected";
        }
    }

    @PostMapping("/login")
<<<<<<< HEAD
<<<<<<< HEAD
    public String login(@RequestParam Map<String, String> formData, Model model, HttpServletRequest request,
            HttpSession session) {
=======
    public String login(@RequestParam Map<String,String> formData, Model model, HttpServletRequest request, HttpSession session){
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
    public String login(@RequestParam Map<String,String> formData, Model model, HttpServletRequest request, HttpSession session){
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
        // processing login
        String name = formData.get("name");
        String pwd = formData.get("password");
        List<User> userlist = userRepo.findByNameAndPassword(name, pwd);
<<<<<<< HEAD
<<<<<<< HEAD
        if (userlist.isEmpty()) {
            return "users/loginfailed";
        } else {
=======
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
        if (userlist.isEmpty()){
            return "users/login";
        }
        else {
<<<<<<< HEAD
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
            // success
            User user = userlist.get(0);
            request.getSession().setAttribute("session_user", user);
            model.addAttribute("user", user);
            return "users/protected";
        }
    }

    @GetMapping("/logout")
<<<<<<< HEAD
<<<<<<< HEAD
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "users/login";
=======
    public String destroySession(HttpServletRequest request){
        request.getSession().invalidate();
        return "/users/login";
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
    public String destroySession(HttpServletRequest request){
        request.getSession().invalidate();
        return "/users/login";
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
    }

}

package com.springapp.notes.mvc.controllers;

import java.util.Arrays;
import java.util.Comparator;

import java.security.Principal;

import com.springapp.notes.entities.Authority;
import com.springapp.notes.entities.User;
import com.springapp.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 */
@Controller
public class MainController {

   // @Autowired
    Comparator<String> comparator;

   // @Autowired
    //NoteServiceImpl noteService;
    @Autowired
    UserRepository userRepository;




    @RequestMapping(value = "/secur", method = RequestMethod.GET)
    public String getToSecurPage(Model model, Principal principal){
        model.addAttribute("username", principal.getName());
        model.addAttribute("message", "we get to secur page");
        return "secur";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
    @RequestMapping(value = "/loginerror", method = RequestMethod.GET)
    public String loginerror(Model model){
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public String getToAddUserPage(){
        return "add_user";
    }
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String addUser(@RequestParam("userName") String userName,
                          @RequestParam("password") String password){
        Authority authority = new Authority();

        authority.setAuthority("ROLE_USER");

        User user = new User();
        authority.setUser(user);
        user.setPassword(password);
        user.setUserName(userName);
        user.setAuthorities(Arrays.asList(authority));
        user.setEnabled(true);
        userRepository.save(user);

        return "add_user";
    }
}

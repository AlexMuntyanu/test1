package com.springapp.notes.mvc.controllers;

import java.util.Comparator;

import com.springapp.notes.services.NoteService;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    NoteService noteService;


    @RequestMapping(value = "/secur", method = RequestMethod.GET)
    public String getToSecurPage(Model model, Principal principal){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)auth.getPrincipal();


        model.addAttribute("username", principal.getName());
        model.addAttribute("pass", user.getPassword());
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

        return "add_user";
    }
}

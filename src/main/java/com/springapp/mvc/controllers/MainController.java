package com.springapp.mvc.controllers;

import java.util.Comparator;

import com.springapp.notes.services.NoteServiceImpl;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
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
    NoteServiceImpl noteService;

    @RequestMapping(value = "/")
    public String first(){
        System.out.println("Logging, in controller right now");
        return "first";
    }

    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public String compare(@RequestParam("input1") String input1,
                          @RequestParam("input2") String input2, Model model) {


        int result = comparator.compare(input1, input2);
        String inEnglish = (result < 0) ? "less than" : (result > 0 ? "greater than" : "equal to");

        String output = "According to our Comparator, '" + input1 + "' is " + inEnglish + "'" + input2 + "'";

        model.addAttribute("output", output);
        return "compareResult";
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getNotes(Model model){
        model.addAttribute("items", noteService.getNotes());
        return "notes";
    }

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
    public String login(Model model){
        return "login";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model){
        return "login";
    }
    @RequestMapping(value = "/loginerror", method = RequestMethod.GET)
    public String loginerror(Model model){
        model.addAttribute("error", "true");
        return "login";
    }
}

package com.springapp.notes.mvc.controllers;

import java.util.Comparator;

import java.security.Principal;

import com.springapp.notes.entities.Authority;
import com.springapp.notes.entities.User;
import com.springapp.notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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

        Md5PasswordEncoder encoder =  new Md5PasswordEncoder();
        String hashedPass = encoder.encodePassword(password,false);
        User user = new User();
        user.setUserName(userName);
        user.setPassword(hashedPass);
        user.setEnabled(true);
        user.getAuthorities().add(new Authority("ROLE_ADMIN",user));
        userRepository.save(user);

        return "secur";
    }
}

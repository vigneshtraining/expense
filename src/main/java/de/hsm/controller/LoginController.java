package de.hsm.controller;


import de.hsm.persistent.Expense;
import de.hsm.persistent.Participant;
import de.hsm.persistent.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class LoginController {

    public static  List<Participant> participantList = new ArrayList<>();
    public static  List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        userList.add(user);
        model.addAttribute("user", user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("error1", false);
        return "login";
    }


    @PostMapping("/login")
    public String login(@Valid User usr, BindingResult bindingResult, Model model) {
        if(userList.contains(usr)) {
            model.addAttribute("expense", new ArrayList<Expense>());
            return "redirect:/participant";
        } else {
            model.addAttribute("error1", true);
            return "redirect:/login";
        }
    }


    @GetMapping("/participant")
    public String participants(Model model) {
        model.addAttribute("participant", new Participant());
        model.addAttribute("participantList", participantList);
        return "template";
    }

    @PostMapping("/participant")
    public String addParticipant(@Valid Participant participant, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "template";
        }
        participant.setParticipantId(participantList.size()+1);
        participantList.add(participant);
        model.addAttribute("participant", participant);
        model.addAttribute("participantList", participantList);
        return "redirect:/participant";
    }

    @GetMapping("/deleteparticipant/{participantId}")
    public String delete(@PathVariable int participantId) {
        Iterator itr = participantList.iterator();
        while(itr.hasNext()) {
            Participant p = (Participant) itr.next();
            if(p.getParticipantId() == participantId)
                itr.remove();
        }

        return "redirect:/participant";
    }
}

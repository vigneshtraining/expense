package de.hsm.controller;

import de.hsm.persistent.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseSummaryController {

    @GetMapping("/expenseSummary")
    public String index() {
        return "index";
    }

    @PostMapping("/expenseSummary")
    public String registerUser(User usr) {
        return "redirect:/index";
    }
}

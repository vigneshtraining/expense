package de.hsm.controller;

import de.hsm.persistent.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.*;

@Controller
public class ExpenseController {

    public static List<Expense> expenseList = new ArrayList<>();


    @GetMapping("/expense")
    public String expenseSummary(Model model) {
        Expense expense = new Expense();
        expense.setParticipantList(LoginController.participantList);

        model.addAttribute("expenseList", expenseList);
        model.addAttribute("exp", expense);

        return "view";
    }

    @PostMapping("/expense")
    public String addExpense(@Valid Expense exp, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            exp.setParticipantList(LoginController.participantList);
            model.addAttribute("exp", exp);
            return "view";
        }
        model.addAttribute("expenseList", expenseList);
        exp.setParticipantList(LoginController.participantList);
        model.addAttribute("exp", new Expense());
        exp.setExpId(expenseList.size()+1);
        expenseList.add(exp);

        return "view";
    }

    @GetMapping("/splitExpense")
    public String splitExpense(Model model) {
        Map<Payment, Long> participantSplit = new HashMap<>();
        for (Expense e : expenseList) {
            Long share = Long.valueOf(e.getAmount() / e.getPlist().length);
            for (String participant : e.getPlist()) {
                if(!participant.equalsIgnoreCase(e.getPayee())) {
                    Payment p = new Payment(participant, e.getPayee(), share, e.getDescription());
                    Long total = share;
                    if (participantSplit.get(p) != null)
                        total = participantSplit.get(p) + share;

                    participantSplit.put(p, total);
                }
            }
        }

        for(Payment p: participantSplit.keySet()) {
            Payment temp = new Payment(p.getPayer(), p.getPayee());
            if(participantSplit.containsKey(temp) ) {
                Long share = participantSplit.get(temp);
                if(participantSplit.get(p) !=0 && share!=0) {
             //   if(p.getShare()!=0 && share !=0) {
                    if (participantSplit.get(p) > share) {
                        share = participantSplit.get(p) - share;
                        participantSplit.put(p, share);
                        participantSplit.put(temp, 0L);
                    } else {
                        share = share - participantSplit.get(p);
                        participantSplit.put(temp, share);
                        participantSplit.put(p, 0L);
                    }
                }
            }
        }

        model.addAttribute("expenseSplit", participantSplit);

        return "creategroupexpense";
    }

    @PostMapping("/splitExpense")
    public String addExpenseSplit(@Valid SplitExpense splitExpense, BindingResult bindingResult, Model model) {
        List<ExpenseSplit> expSplit = new ArrayList<ExpenseSplit>();
        Integer amt = (splitExpense.getAmount()) / splitExpense.getPlist().length;
        for (String participantName : splitExpense.getPlist()) {
            expSplit.add(new ExpenseSplit(participantName, amt));
        }
        SplitExpense splitExp = new SplitExpense();
        splitExp.setParticipantList(LoginController.participantList);
        model.addAttribute("splitExpense", splitExp);
        model.addAttribute("expenseSplit", expSplit);

        return "creategroupexpense";
    }



    @GetMapping("/delete/{expId}")
    public String delete(@PathVariable int expId) {
        Iterator itr = expenseList.iterator();
        while(itr.hasNext()) {
            Expense exp = (Expense) itr.next();
            if(exp.getExpId() == expId)
                itr.remove();
        }

        return "redirect:/expense";
    }

}


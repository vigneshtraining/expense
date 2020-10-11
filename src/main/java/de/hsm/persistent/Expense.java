package de.hsm.persistent;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

public class Expense {
    private Integer expId;
    @NotEmpty
    private String expDate;
    @NotEmpty
    private String description;

    @NotNull(message="Please enter an amount")
    private Integer amount;

    private List<Participant> participantList;
    @NotEmpty
    private String payee;
    @NotEmpty
    private String[] plist;


    public Expense() {
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String[] getPlist() {
        return plist;
    }

    public void setPlist(String[] plist) {
        this.plist = plist;
    }

    public Integer getExpId() {
        return expId;
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }
}

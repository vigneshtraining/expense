package de.hsm.persistent;

import java.util.List;

public class SplitExpense {

    private String description;
    private Integer amount;
    private List<Participant> participantList;
    private String[] plist;

    public SplitExpense() {
    }

    public SplitExpense(String description, Integer amount, List<Participant> participantList) {
        this.description = description;
        this.amount = amount;
        this.participantList = participantList;
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

    public String[] getPlist() {
        return plist;
    }

    public void setPlist(String[] plist) {
        this.plist = plist;
    }
}

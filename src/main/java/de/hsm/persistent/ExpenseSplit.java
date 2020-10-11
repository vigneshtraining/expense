package de.hsm.persistent;

public class ExpenseSplit {
    private String participantName;
    private Integer share;

    public ExpenseSplit() {

    }

    public ExpenseSplit(String participantName, Integer share) {
        this.participantName = participantName;
        this.share = share;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }
}

package de.hsm.persistent;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Participant {
    private Integer participantId;
    @NotEmpty
    private String participantName;

    @NotEmpty
    private String mobileNum;

    public Participant() {
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Participant(String participantName, String mobileNum) {
        this.participantName = participantName;
        this.mobileNum = mobileNum;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return participantName.equals(that.participantName) &&
                mobileNum.equals(that.mobileNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName, mobileNum);
    }
}

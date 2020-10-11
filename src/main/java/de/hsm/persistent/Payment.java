package de.hsm.persistent;

import java.util.Objects;

public class Payment {
    private String payee;
    private String payer;
    private long share;
    private String event;

    public Payment() {
    }

    public Payment(String payee, String payer) {
        this.payee = payee;
        this.payer = payer;
    }

    public Payment(String payee, String payer, long share, String event) {
        this.payee = payee;
        this.payer = payer;
        this.share = share;
        this.event = event;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public long getShare() {
        return share;
    }

    public void setShare(long share) {
        this.share = share;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return payee.equals(payment.payee) &&
                payer.equals(payment.payer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payee, payer);
    }
}

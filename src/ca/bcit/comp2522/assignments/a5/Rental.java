package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

public class Rental implements Serializable {

    private String comments;
    private Condition conditionAfter;
    private Condition conditionBefore;
    private Date date;
    private long rentalID;
    private long serialVersionUID;

    public String getComments() {
        return comments;
    }

    public Condition getConditionAfter() {
        return conditionAfter;
    }

    public Condition getConditionBefore() {
        return conditionBefore;
    }

    public Date getDate() {
        return date;
    }

    public long getRentalID() {
        return rentalID;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setConditionAfter(Condition conditionAfter) {
        this.conditionAfter = conditionAfter;
    }

    public void setConditionBefore(Condition conditionBefore) {
        this.conditionBefore = conditionBefore;
    }

    public void setRentalID(long rentalID) {
        this.rentalID = rentalID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o.getClass() == this.getClass())) {
            return false;
        }
        Rental other = (Rental) o;
        return other.comments.equals(comments)
                && other.date.equals(date)
                && other.rentalID == rentalID;
    }

    @Override
    public int hashCode() {
        final int multiplier = 7;
        int result = 5;
        result = multiplier * result + comments.hashCode();
        result = multiplier * result + date.hashCode();
        result = multiplier * result + Long.hashCode(rentalID);
        return result;
    }

    @Override
    public String toString() {
        return "Rental";
    }
}

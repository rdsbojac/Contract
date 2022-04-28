package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installments {

    private static SimpleDateFormat simpledf = new SimpleDateFormat("dd/MM/yyyy");
    private Date dueDate;  // data da parcela
    private Double amount; // quantidade de parcelas

    public Installments(Date dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return simpledf.format(dueDate) + " - " + String.format("%.2f",amount);
    }
}

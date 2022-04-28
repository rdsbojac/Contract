package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    private Integer number;     // numero do contrato
    private Date date;          // data do contarto
    private Double totalValues; // valor total do contrato

    List<Installments> installments = new ArrayList<Installments>();

    public Contract(Integer number, Date date, Double totalValues) {
        this.number = number;
        this.date = date;
        this.totalValues = totalValues;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValues() {
        return totalValues;
    }

    public void setTotalValues(Double totalValues) {
        this.totalValues = totalValues;
    }

    public List<Installments> getInstallments() {
        return installments;
    }


}

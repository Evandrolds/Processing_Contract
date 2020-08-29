package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Evandro
 */
public class Contract {
   private Integer contract;
   private Date date;
   private Double amount;
    
    List<Installment>installments = new ArrayList<>();
    public Contract() {
    }

    public Contract(Integer contract, Date date, Double amount) {
        this.contract = contract;
        this.date = date;
        this.amount = amount;
    }

    public Integer getContract() {
        return contract;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }
    public List<Installment> getInstallments(){
        return installments;
    }
}

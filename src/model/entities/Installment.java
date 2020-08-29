package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Evandro
 */
public class Installment {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
    @Override
    public String toString() {
        return sdf.format(duoDate) + " - "+"R$"+String.format("%.2f",  amount);
    }
    private Date duoDate;
    private Double amount;

    public Installment(Date duoDate, Double amount) {
        this.duoDate = duoDate;
        this.amount = amount;
    }
    public Date getDuoDate() {
        return duoDate;
    }
    public Double getAmount() {
        return amount;
    }
    
}

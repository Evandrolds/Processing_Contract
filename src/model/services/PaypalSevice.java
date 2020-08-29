package model.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.entities.Installment;

/**
 *
 * @author Evandro
 */
public class PaypalSevice implements OnlinePaymentService{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public double paymenteFee(double amount) {
      return amount * 0.02;
       
        
    }

    @Override
    public double interest(double amount, Integer months) {
        return amount * months * 0.01;
        
        
    }
    
}

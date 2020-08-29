package model.services;

/**
 *
 * @author Evandro
 */
public interface OnlinePaymentService {
     double paymenteFee(double amount);
     double interest(double amount,Integer months);
   
}

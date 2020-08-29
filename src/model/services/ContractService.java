package model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.entities.Contract;
import model.entities.Installment;

/**
 *
 * @author Evandro
 */
public class ContractService {
   private  OnlinePaymentService OnlinePaymentService;
   // aqui foi feito uma ingeção de dependencia
   public ContractService(OnlinePaymentService OnlinePaymentService){
       this.OnlinePaymentService =OnlinePaymentService;
   }
    
    List<Contract >list = new ArrayList<>();
    
    // Princípio da INVERSAO DE CONTROLE
    public void processContract(Contract contract,Integer months){
            PaypalSevice ps = new PaypalSevice();
        double basicQuota = contract.getAmount() / months;
        for(int i=1; i<= months; i++){
           double updateQuota = basicQuota + OnlinePaymentService.interest(basicQuota, i);
           double fullQuota = updateQuota + OnlinePaymentService.paymenteFee(updateQuota);
            Date duoDate = addMonths(contract.getDate(),i);
            contract.getInstallments().add(new Installment(duoDate, fullQuota));
        }
        
    }
    private Date addMonths(Date date, int numMonths){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.MONTH, numMonths);
       return calendar.getTime();
    }
}

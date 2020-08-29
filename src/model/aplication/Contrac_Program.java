package model.aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalSevice;

/**
 *
 * @author Evandro
 */
public class Contrac_Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(" Enter contract data...");
        System.out.print(" Numebr: ");
        int contract = sc.nextInt();
        System.out.print(" Date (dd/MM/yyyy :");
        Date date = sdf.parse(sc.next());
        System.out.print( " Contract value: R$");
        double totalValue = sc.nextDouble();
        System.out.print(" Enter number Installments:");
        int months = sc.nextInt();
       
        Contract contracts = new Contract(contract, date, totalValue);
        ContractService cs = new ContractService(new PaypalSevice());
        cs.processContract(contracts, months);
        System.out.println("Installments ");
        for(Installment it:contracts.getInstallments()){
            System.out.println(it);
            
        }
            
        
        
     
        sc.close();
        
    }
}

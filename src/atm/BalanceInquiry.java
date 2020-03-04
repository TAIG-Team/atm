/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author andreasimental
 */
public class BalanceInquiry extends Transaction{

    public BalanceInquiry(int currentAccountNumber, Screen screen, BankDatabase bankDatabase) {
        super(currentAccountNumber, screen, bankDatabase);
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

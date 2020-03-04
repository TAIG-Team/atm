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
public class Deposit extends Transaction {
    private int amount;
    private Keypad keypad;
    private DepositSlot depositSlot;

    public Deposit(int currentAccountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, DepositSlot depositSlot) {
        
        super(currentAccountNumber, screen, bankDatabase);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

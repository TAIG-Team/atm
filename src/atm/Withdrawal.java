/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;


/**
 *
 * @author TAIG Team
 */

public class Withdrawal extends Transaction {

    private int amount;
    private Keypad keypad;
    private CashDispenser cashDispenser;

    private final static int CANCELED = 6;

    // Withdrawal constructor
    public Withdrawal(int currentAccountNumber, Screen screen, BankDatabase bankDatabase, Keypad bankKeypad, CashDispenser bankCashDispenser) {

        super(currentAccountNumber, screen, bankDatabase);

        keypad = bankKeypad;
        cashDispenser = bankCashDispenser;
    }

    public void execute() {
        boolean cashDispensed = false;
        double availableBalance;

        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        do {

            amount = displaywithdrawalMenu();

            if (amount != CANCELED) {

                availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

                if (amount <= availableBalance) {

                    if (cashDispenser.isSufficientCashAvailable(amount)) {

                        bankDatabase.debit(getAccountNumber(), amount);

                        cashDispenser.dispenseCash(amount);
                        cashDispensed = true;

                        screen.displayMessageLine(
                                "\nPlease take your cash.");
                    } else {
                        screen.displayMessageLine(
                                "\nInsufficient cash available in the ATM."
                                + "\n\nPlease choose a smaller amount.");
                    }
                } else {
                    screen.displayMessageLine(
                            "\nInsufficient funds in your account."
                            + "\n\nPlease choose a smaller amount.");
                }
            } else {
                screen.displayMessageLine("\nCanceling transaction...");
                return;
            }
        } while (!cashDispensed);

    }

    private int displaywithdrawalMenu() {
        int choice = 0; 

        Screen screen = getScreen();
        
        int amounts[] = {0, 20, 40, 60, 100, 200};

       
        while (choice == 0) {
            // display the menu
            screen.displayMessageLine("\nWithdrawal Menu:");
            screen.displayMessageLine("1 - $20");
            screen.displayMessageLine("2 - $40");
            screen.displayMessageLine("3 - $60");
            screen.displayMessageLine("4 - $100");
            screen.displayMessageLine("5 - $200");
            screen.displayMessageLine("6 - Cancel transaction");
            screen.displayMessage("\nChoose a withdrawal amount: ");
          
            int input = keypad.getInput(); 
            
           if (input >= 1 && input <= 5) {
			   choice = amounts[input]; 
		   } else if (input == CANCELED) {
			   choice = CANCELED;
		   } else
			   screen.displayMessageLine("Invalid . Try again.");
        } 

        return choice;
    } 
} 

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
public class BalanceInquiry extends Transaction{

    public BalanceInquiry( int currentAccountNumber, Screen screen, 
      BankDatabase bankDatabase )
   {
      super( currentAccountNumber, screen, bankDatabase );
   }

    @Override
    public void execute()
   {

      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      double availableBalance = 
         bankDatabase.getAvailableBalance( getAccountNumber() );

      double total = 
         bankDatabase.getTotalBalance( getAccountNumber() );

      screen.displayMessageLine( "\nBalance Information:" );
      screen.displayMessage( " - Available balance: " ); 
      screen.displayDollarAmount( availableBalance );
      screen.displayMessage( "\n - Total balance:     " );
      screen.displayDollarAmount( total );
      screen.displayMessageLine( "" );
   } 

    
}

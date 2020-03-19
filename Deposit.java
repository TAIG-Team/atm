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
public class Deposit extends Transaction {
   private double amount; 
   private Keypad keypad; 
   private DepositSlot depositSlot; 
   private final static int CANCELED = 0; 

 
   public Deposit( int currentAccountNumber, Screen screen, 
      BankDatabase bankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot )
   {
    
      super( currentAccountNumber, screen, bankDatabase );

      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   } 
   
   public void execute()
   {
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();
      amount = promptForDepositAmount(); 
    
      if ( amount != CANCELED )
      {
         screen.displayMessage( 
            "\n Please insert Envelope which contains: " );
         screen.displayDollarAmount( amount );
         screen.displayMessageLine( "." );

        
         boolean envelopeReceived = depositSlot.isEnvelopeReceived();

         if ( envelopeReceived )
         {  
            screen.displayMessageLine( "\nYour envelope has been " + 
               "received." );
            
            bankDatabase.credit( getAccountNumber(), amount ); 
         } 
         else
         {
            screen.displayMessageLine( "\nYou did not insert an " +
               "envelope." );
         } 
      } 
      else 
      {
         screen.displayMessageLine( "\nCanceling transaction..." );
      } 
   } 

   private double promptForDepositAmount()
   {
      Screen screen = getScreen(); 

      screen.displayMessage( "\nPlease enter a deposit amount (or 0 to cancel): " );
      int input = keypad.getInput(); 
      
      if ( input == CANCELED ) 
         return CANCELED;
      else
      {
         return ( double ) input ;
      } 
   } 
}

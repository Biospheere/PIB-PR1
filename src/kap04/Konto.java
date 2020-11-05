package kap04;

public class Konto {

    private final int accountNumber;
    private final String owner;
    private double balance;

    /**
     * 
     * @param owner the name of the owner
     * @param accountNumber the account number of the owner
     * @param balance the initial balance of the bank account
     */
    public Konto(final String owner, final int accountNumber, final double balance){
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Constructor for bank account with default balance 0
     * @param owner the name of the owner
     * @param accountNumber the account number of the owner
     */
    public Konto(final String owner, final int accountNumber){
        this(owner, accountNumber, 0d);
    }

    /**
     * 
     * @param amount to pay in
     * @return the balance after pay in
     */
    public double payIn(final double amount){
        balance += amount;
        return balance;
    }

    /**
     * 
     * @param amount to pay out
     * @return the balance after pay out
     */
    public double payOut(final double amount){
        balance -= amount;
        return balance;
    }

    /**
     * 
     * @return the account number 
     */
    public int getAccountNumber(){
        return accountNumber;
    }

    /**
     * 
     * @return the owner;
     */
    public String getOwner(){
        return owner;
    }

    /**
     * 
     * @return the current balance of the account
     */
    public double getBalance(){
        return balance;
    }

    public String toString() {
        return "Account number: " + accountNumber 
           + ", Owner: " + owner
           + ", Balance: " + balance;
    }
    
}

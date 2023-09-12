import java.util.ArrayList;

public class Account {
    private String name;
    private String accountNumber;

    private double balance;
    private String AccountType;
    private ArrayList<String > transactionHistroy;

    public Account( String name,String accountNumber, double balance, String AccountType){
        this.name =name;
        this.accountNumber =accountNumber;
        this.balance=balance ;
        this.AccountType =AccountType;
        this.transactionHistroy =new ArrayList<>();

    }

    public String getAccountType(){

        return AccountType;
    }
    public String getAccountnumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance){
        this.balance=balance ;

    }

    public void setTransactionHistroy(ArrayList<String> transactionHistory){
        this.transactionHistroy=transactionHistory;
    }


    public void deposit(double amount) {
        try{
            if (amount<=0){
                throw new IllegalAccessException("invalid amount please enter valid amount") ;
            }
            balance+=amount;
            System.out.println("the new balance "+amount );
            recordTransactionHistory("new balance - "+ amount);
            System.out.println("deposit succcessful: ");

        }catch(IllegalAccessException e){
            System.out.println("error " + e.getMessage());
        }
    }

    public void withdrawal(double amount){
        try{
            if(amount <= 0 || amount>balance ){
                throw new IllegalAccessException("invalid amount") ;
            }
            else{
                balance=balance-amount;
                System.out.println("total balance " + balance );
                recordTransactionHistory("your balance " + balance );
            }
        }catch(IllegalAccessException e){
            System.out.println("Error " + e.getMessage());
        }
    }
    public double getBalance() {
        return balance;
    }



    public void displayTransactionHistory() {
        System.out.println("your transaction history is: ");
        for(String transaction: transactionHistroy ){
            System.out.println(transaction );
        }
    }
    private void recordTransactionHistory(String transaction){
        transactionHistroy.add(transaction );
    }
}


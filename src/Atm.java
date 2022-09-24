public class Atm {
    private double balance;
    private double depositAmount;
    private double withdrawAmount;
    //default constructor
    Atm(){

    }
// create a getter and setter method for access of private variables outside the class
// for balance

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    //for depositamount
    public double getDepositAmount(){
        return depositAmount;
    }
    public void setDepositAmount(double depositAmount){
        this.depositAmount=depositAmount;
    }
    //for withdrawAmount
    public double getWithdrawAmount(){
        return withdrawAmount;
    }
    public void setWithdrawAmount(double withdrawAmount){
        this.withdrawAmount=withdrawAmount;
    }
}

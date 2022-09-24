abstract class atmInter {
    abstract public void viewBalance();
    abstract public void withdrawAmount(double withdrawAmount);
    abstract public void depositAmount(double depositAmount);
}
//-----Business-class-------
class atmImplementation extends atmInter{
    Atm a = new Atm();

    public void viewBalance(){
        System.out.println("available balance is"+a.getBalance());

    }

    public void withdrawAmount(double withdrawAmount){
        if( withdrawAmount<=a.getBalance()){
            System.out.println(withdrawAmount+"is withdrawn successfully !!!");
            a.setBalance(a.getBalance()-withdrawAmount);
            viewBalance();
        }
        else {
            System.out.println("insufficient balance");
        }

    }

    public void depositAmount(double depositAmount){
        System.out.println(depositAmount+"Amount depositted successfully!!!");
        a.setBalance(a.getBalance()+depositAmount);
        viewBalance();
    }
}

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javax.xml.transform.stream.StreamSource;
import java.io.FileReader;
public class Main {
    static ArrayList<Accountmembers> accountHolders = new ArrayList<>();
    public static  void main(String[] args) throws Exception {
        Main m = new Main();
        m.jsonStuff();
        atmImplementation am = new atmImplementation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ABC ATM");
        System.out.print("Enter the account number :");
        String accountNumber = sc.next();
        System.out.print("Enter the pin :");
        String accountPin = sc.next();
        for (int i = 0; i < accountHolders.size(); i++) {
             if((accountNumber.equals(accountHolders.get(i).accountNumber)) && (accountPin.equals(accountHolders.get(i).accountPin))) {
                System.out.println("Validation is successfull");
                while (true) {
                    System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit TheAmount\n4.Exit");
                    System.out.println("Enter the choice :");
                    int ch = sc.nextInt();
                    switch(ch){
                        case 1:
                        am.viewBalance();
                        break;
                        case 2:
                        System.out.println("Enter the Amount to Withdraw");
                        double amountWithdraw = sc.nextDouble();
                        am.withdrawAmount(amountWithdraw);
                        break;
                        case 3:
                        System.out.println("Enter Amount To Deposit");
                        double amountDeposit = sc.nextDouble();
                        am.depositAmount(amountDeposit);
                        break;
                        case 4:
                        System.out.println("Collect Your ATM Card\nThank You For Using Our ATM");
                        System.exit(0);
                        break;
                        default:
                            System.out.println("Please Enter the correct choice");
                        }
                    }
            }else {
                 System.out.println("your account number or pin is incorrect");
                 break;
             }
    }
}
    void jsonStuff() throws Exception {
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\SwiftAnt\\IdeaProjects\\atm\\src\\accountDetails.json"));

        JSONArray ar = (JSONArray) obj;
        for (Object account : ar) {
            String accountnumber = (String) ((JSONObject) account).get("accountNumber");
            String accountpin = (String) ((JSONObject) account).get("accountPin");
            String name = (String) ((JSONObject) account).get("name");
            String location = (String) ((JSONObject) account).get("location");
            accountHolders.add(new Accountmembers(accountnumber,accountpin,name,location));
        }
    }
}
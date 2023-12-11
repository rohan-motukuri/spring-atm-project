import java.util.ArrayList;
import java.util.Scanner;

public class SBI implements ReserveBank {
    // static String[] accountNumbers;
    // String currentAccountNumber = accountNumbers.length == 0 ? "0000000000001" : accountNumbers[accountNumbers.length - 1];

    private Scanner sc = new Scanner (System.in);
    String name = "", address, accountType;
    long mobile, myAccountNumber;
    double balance;
    static long accountNumbers = 8110001;
    static ArrayList<SBI> accountList = new ArrayList<SBI>();

    public SBI () {
        myAccountNumber = accountNumbers++;
        accountList.add(this);
    }

    @Override // Also, Then the visibility from inheretence has to be specified ?
    public void createAccount () { 
        printf("Enter Name: "); name = sc.nextLine();
        printf("Enter Adress: "); address = sc.nextLine();
        printf("Enter Account Type: "); accountType = sc.nextLine();
        printf("Enter Mobile Number: "); mobile = sc.nextLong();
        // myAccountNumber = accountNumber++; // Doesn't work, Since static variables cannot be resolved to regular variable
    }

    @Override
    public void getAccountDetails () {
        printf("Your Name: " + name);
        printf("Your Address: " + address);
        printf("Your Account Number: " + myAccountNumber);
        printf("Your Account Type: " + accountType);
        printf("Your Contact: " + mobile);
        printf("Your Balance: " + balance);
    }

    @Override
    public void debit (double x, long accntNumber) {
        int index = (int) accntNumber - 8110000;
        
        if(index >= accountList.size()) {
            printf("Invalid Account Number");
            return;
        }

        if(balance - x < 0) {
            printf("Insufficient Funds");
            return;
        }
        if(accntNumber == this.myAccountNumber) {
            printf("Transfer money to another account please");
            return;
        }
        balance -= x;
        accountList.get(index).balance += x;
        printf("Debit'd "+x+" amount to account " + accntNumber + " held by " + accountList.get(index).name);
    } 

    @Override
    public void credit (double x) {
        balance += x;
        printf("Creditted "+x+" amount into your bank");
    } 

    @Override
    public double getBalance () {
        return balance;
    }

    @Override
    public void applyLoan () { 

    }

    public SBI login (long accountNumber) {
        int index = (int) accountNumber - 8110000;

        if(index >= accountList.size() || index < 0) {
            printf("Invalid Account Number");
            return this;
        }
        accountList.remove(accountList.size() - 1);
        accountNumbers--;
        return accountList.get(index);
    }

    void printf (String s) {
        System.out.println(s);
    } 

    void printf (int x) {
        System.out.println(x);
    }
}

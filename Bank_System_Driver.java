import java.util.Scanner;

public class Bank_System_Driver {
    public static void main (String args[]) {
        // Resource Leak - Never Closed ??????
        Scanner sc = new Scanner (System.in);
        String message = "Welcome to SBI";
        int choice;
        SBI currentUser = new SBI();
        boolean inWelcome = true;

        do {
            printf("----------- " + message + " -------------");

            if(inWelcome)
                printf("1.Log In | 2.Create Account");
            else
                printf("1.Get Account Details | 2.Get Balance | 3.Credit an Amount | 4.Transfer Money");

            do {
                choice = sc.nextInt();
                if(!inWelcome)
                    switch (choice) {
                        case 1: // Get Details
                            currentUser.getAccountDetails();
                            break;
                        
                        case 2: // Get Balance
                            printf("Balance in you account is: " + currentUser.getBalance());
                            break;
                        
                        case 3: // Credit an Amount
                            printf("Please Enter The Amount To Be Credited: ");
                            currentUser.credit(sc.nextDouble());
                            break;
                        
                        case 4: // Debit an Amount
                            printf("Please Enter Amount to be Debited and The Account Number: ");
                            currentUser.debit(sc.nextDouble(), sc.nextLong(choice));
                            break;
                            
                        default:
                            printf("Please select a valid option.");
                            break;
                    }
                else
                    if (choice == 1) {inWelcome = false; choice = 5; currentUser = currentUser.login(choice);}
                    else if(choice == 2) {inWelcome = false; choice = 5;currentUser.createAccount();}
                    else {
                        choice = 5;
                        printf("Please select a valid option");
                    }
            } while (!inWelcome && choice != 5 && choice != 6);
 
            inWelcome = false;
        } while (choice != 6);

        sc.close();

    }

    static void printf (String s) {
        System.out.println(s);
    } 

    static void printf (int x) {
        System.out.println(x);
    }
}

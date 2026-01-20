import java.util.Scanner;

public class ATM {
    static int balance = 0;

    static void checkBalance() {
        System.out.println("Current Balance : "+balance);
    }

    static void deposit(int amount) {
        balance+=amount;
        System.out.println("deposited "+amount+" successfully");
    }

    static void withdraw(int amount) {
        if (balance<amount) System.out.println("Not enough balance....");
        else {
            balance-=amount;
            System.out.println(amount+" withdrawal successful");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n---- Welcome to ATM simulation ----");
            System.out.println("choose the operation");
            System.out.println("1. Check balance \n2. Deposit amount \n3. Withdraw amount \n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 4) System.exit(0);
            if (choice > 4) System.out.println("Please verify the input and try again");

            try {
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit : ");
                        int depositAmount = sc.nextInt();
                        deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter the amount to withdraw : ");
                        int withdrawalAmount = sc.nextInt();
                        withdraw(withdrawalAmount);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

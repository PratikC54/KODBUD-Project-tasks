import java.util.Scanner;

public class Calculator {
    static int add(int a, int b) {
        return a+b;
    }

    static int sub(int a, int b) {
        return a-b;
    }

    static int mul(int a, int b) {
        return a*b;
    }

    static int div(int a, int b) {
        if(b==0) throw new ArithmeticException("Can't divided by zero");
        return a/b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Choose the Operation \n 1. Addition \n 2. Subtraction \n 3. Multiplication \n 4. Division \n 5. Exit ");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if(choice==5) System.exit(0);
            if(choice>5) System.out.println("Please verify the input and enter a valid one.");

            System.out.println("Enter a number : ");
            int a = sc.nextInt();

            System.out.println("Enter another number : ");
            int b = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Addition of two numbers : " + add(a, b));
                        break;
                    case 2:
                        System.out.println("Subtraction of two numbers : " + sub(a, b));
                        break;
                    case 3:
                        System.out.println("Multiplication of two numbers : " + mul(a, b));
                        break;
                    case 4:
                        System.out.println("Division of two numbers : " + div(a, b));
                        break;
                }
            } catch (ArithmeticException ae) {
                System.out.println(ae.getMessage());
            }
        }
    }
}

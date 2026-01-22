import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Credential {
    Map<String , String> credentialDB = new HashMap<>();

    public void createUser(String username , String password) {
        if (credentialDB.containsKey(username)) System.out.println("User already exists . Please use another username.");
        else credentialDB.put(username,password);
    }

    public void validateUser(String username , String password) {
        if (credentialDB.containsKey(username) && password.equals(credentialDB.get(username)))
            System.out.println("Sign in successfully");
        else System.out.println("Invalid user");
    }
}

public class LoginSystem {

    static String getUsername(Scanner sc) {
        System.out.println("White/Blank spaces are not allowed for username and password");
        System.out.print("Enter username : ");
        return sc.next();
    }

    static String getPassword(Scanner sc) {
        System.out.print("Enter password : ");
        return sc.next();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Credential credential = new Credential();
        while (true){
            System.out.println("-----------Login System-----------");
            System.out.println("1. sign up(New user) \n2. sign in(Existing user)\n3. exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();

            if (choice>3) System.out.println("Enter a valid option");
            switch (choice) {
                case 1:
                    credential.createUser(getUsername(sc) , getPassword(sc));
                    break;
                case 2:

                    if (credential.credentialDB.isEmpty()) System.out.println("No existing user . Please signup.");
                    else credential.validateUser(getUsername(sc) , getPassword(sc));
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}

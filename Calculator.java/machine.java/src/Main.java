import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class ATM {
    private Map<Integer, Account> accounts;

    public ATM () {
        accounts = new HashMap<>();

    }
    private Account authenticateUser (int accountNumber, String password) {
        return null;
    }

    public class ATMProgram {
        public static void main (String[] args) {
            Scanner scanner = new Scanner(System.in);
            ATM ATM = new ATM();

            int accountNumber = getInputNumber(scanner, "Enter account number: ");
            String password = getInputString(scanner, "Enter password: ");

            Account account = ATM.authenticateUser(accountNumber, password);

            if (account != null) {
                handleTransactions(scanner, account);
            } else {
                System.out.println("Authentication failed. Please check your account number and password.");
            }

            scanner.close();
        }

        public static int getInputNumber (Scanner scanner, String prompt) {
            System.out.print(prompt);
            return scanner.nextInt();
        }

        public static String getInputString (Scanner scanner, String prompt) {
            System.out.print(prompt);
            return scanner.next();
        }

        public static void handleTransactions (Scanner scanner, Account account) {
            int choice;

            do {
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                choice = getInputNumber(scanner, "Enter choice: ");

                switch (choice) {
                    case 1 -> System.out.println("Current balance: Ksh" + account.getBalance());
                    case 2 -> {
                        double depositAmount = getInputNumber(scanner, "Enter deposit amount: Ksh");
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                    }
                    case 3 -> {
                        double withdrawAmount = getInputNumber(scanner, "Enter withdrawal amount: Ksh");
                        account.withdraw(withdrawAmount);
                    }
                    case 4 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 4);
        }
    }


}

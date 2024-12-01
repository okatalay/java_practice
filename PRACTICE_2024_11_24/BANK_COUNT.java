package PRACTICE_2024_11_24;

public class BANK_COUNT {

    public static void main(String[] args) {

        double balance = 2900;

        balance = withdraw(balance, 500);
        balance = deposit(balance, 1200);

        System.out.println(multiProcess(2900, 200, 500));

    }

    public static String multiProcess(double balance, double withdraw, double deposit) {
        balance = balance + deposit;

        if (balance >= withdraw) {
            balance -= withdraw;
            return "New balance: " + balance;
        }
        else {
            return "Insufficient Balance";
        }
    }


    public static double withdraw(double balance, double amount) {
        balance -= amount;
        return balance;
    }

    public static double deposit(double balance, double amount) {
        balance += amount;
        return balance;
    }

    public static void showBlance(double balance){
        System.out.println(balance);
    }
}




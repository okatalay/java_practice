package PRACTICE_2024_12_29;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // { "User1" : { "Şifre" : "Password123", "Bakiye" : 5000.0 },  "User2" : { "Şifre" : "Password1236", "Bakiye" : 8000 }}

        Map<String, Map<String, Object>> users = new HashMap<>();

        Map<String, Object> user1 = new HashMap<>();
        user1.put("Şifre", "12345");
        user1.put("Bakiye", 5000.0);

        users.put("User1", user1);

        Map<String, Object> user2 = new HashMap<>();
        user2.put("Şifre", "54321");
        user2.put("Bakiye", 9000.0);

        users.put("User2", user2);

        ATM atm = new ATM();

        System.out.println("Kullanıcı adınızı giriniz: ");
        String username = sc.nextLine();
        System.out.println("Şifrenizi giriniz: ");
        String password = sc.nextLine();

        if (atm.login(username, password, users)){

            System.out.println("Giriş işlemi başarılı");

            while (true) {
                atm.showMenu();
                System.out.println("Yapmak istediğiniz işlemi seçiniz (1-5): ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> atm.showBalance(username, users);
                    case 2 -> atm.depositAmount(username, users, sc);
                    case 3 -> atm.withdrawAmount(username,users,sc);
                    case 4 -> atm.transferMoney(username, users, sc);
                    case 5 -> System.out.println("Çıkış yapılıyor");

                }
            }
        }

        else{
            System.out.println("Hatalı kullanıcı adı ve ya şifre hatalı!");
        }
    }
}

package PRACTICE_2024_12_29;

import java.util.Map;
import java.util.Scanner;

public class ATM {


    // { "User1" : { "Şifre" : "Password123", "Bakiye" : 5000.0 },  "User2" : { "Şifre" : "Password1236", "Bakiye" : 8000 }}


    public boolean login(String username, String password, Map<String, Map<String, Object>> users){

        if(users.containsKey(username)){

            String storedPassword = users.get(username).get("Şifre").toString();

            if(storedPassword.equals(password)){
                return true;
            }
        }
        return false;
    }

    public void showMenu(){

        System.out.println("\nATM Menü: ");
        System.out.println("1. Bakiyeyi Görüntüle");
        System.out.println("2. Para Yatır");
        System.out.println("3. Para Çek");
        System.out.println("4. Para Transferi");
        System.out.println("5. Çıkış");
    }

    public void showBalance(String username, Map<String, Map<String, Object>> users) {


        Object userBalance = users.get(username).get("Bakiye");
        System.out.println("Mevcut bakiyeniz : " + userBalance);
    }

    public void depositAmount(String username, Map<String, Map<String, Object>> users, Scanner sc) {

        System.out.println("Yatırmak istediğiniz miktarı giriniz: ");
        double amount = sc.nextDouble();
        Object userBalance = users.get(username).get("Bakiye");

        double currentBalance = ((Number) userBalance).doubleValue();
        double newBlance = currentBalance + amount;

        users.get(username).put("Bakiye", newBlance);

        System.out.println("Para yatırma işlemi başarılı.");
        System.out.println("Güncel bakiyeniz : " + newBlance);
    }



    public void withdrawAmount(String username, Map<String, Map<String, Object>> users, Scanner sc) {

        Map<String, Object> userData = users.get(username);
        double currentBalance = (double) userData.get("Bakiye");

        System.out.println("Çekmek istediğiniz miktarı giriniz: ");
        double amount = sc.nextDouble();

        if (amount > currentBalance) {
            System.out.println("Yetersiz bakiye !");
        }
        else {
            double newBalance = currentBalance - amount;
            userData.put("Bakiye", newBalance);
            System.out.println("Para çekme işlemi başarılı. Güncel bakiyeniz : " + newBalance);
        }
    }

    // { "User1" : { "Şifre" : "Password123", "Bakiye" : 5000.0 },  "User2" : { "Şifre" : "Password1236", "Bakiye" : 8000 }}

    public void transferMoney(String username, Map<String, Map<String, Object>> users, Scanner sc) {

        Map<String, Object> userData = users.get(username);
        double currentBalance = (double) userData.get("Bakiye");

        System.out.println("Transfer yapmak istediğiniz miktarı giriniz: ");
        double transferAmount = sc.nextDouble();
        sc.nextLine();

        if (transferAmount > currentBalance) {
            System.out.println("Yetersiz bakiye !");
        }
        else {
            System.out.println("Transfer yapmak istediğiniz kullanıcı ismini giriniz: ");
            String transferName = sc.nextLine();

            if(username.equals(transferName)){
                System.out.println("Kendinize transfer yapamazsınız !");

                return;
            }

            if(users.containsKey(transferName)){

                Map<String, Object> transferData = users.get(transferName);
                double transferUserBalance = (double) transferData.get("Bakiye");

                userData.put("Bakiye", currentBalance-transferAmount);
                transferData.put("Bakiye", transferUserBalance+transferAmount);

                System.out.println("Transfer işlemi başarıyla tamamlandı. Mevcut bakiyeniz: " + (currentBalance-transferAmount));

            }
            else {
                System.out.println("Girmiş olduğunuz kullanıcı sistemde mevcut değil.");
            }
        }




    }

}

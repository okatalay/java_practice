package PRACTICE_2024_11_17;

import java.util.Scanner;

public class MULT_TABLE {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sayıyı giriniz");


        int sayi = sc.nextInt();

        // 1-2-3-4-5...
        for (int i = 1; i <= 10; i++) {

            // 5 x 2 = 10
            System.out.println(sayi + "x" + i + "=" + (sayi*i));

        }


    }
}

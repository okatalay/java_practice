package PRACTICE_2024_11_17;

import java.util.Scanner;

public class MEAN_NUMBER {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0;

        System.out.println("Kac sayı girmek istiyorsun:");

        int n = sc.nextInt();

        for (int i = 1; i <=n ; i++) {

            System.out.println(i + " . sayıyı gir:");
            int number = sc.nextInt();

            sum += number;
        }

        System.out.println("Ortalama : " + (sum/n));





        }
    }


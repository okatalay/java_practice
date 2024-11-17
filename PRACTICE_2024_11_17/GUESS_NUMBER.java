package PRACTICE_2024_11_17;

import java.util.Random;
import java.util.Scanner;

public class GUESS_NUMBER {

    public static void main(String[] args) {

        Random rand = new Random();
        int guess = rand.nextInt(9) + 1;

        Scanner sc = new Scanner(System.in);

        int guessNum;

        do {
            System.out.println("Guess a number between 1 and 10");
            guessNum = sc.nextInt();

            if (guessNum == guess) {
                System.out.println("Guess Correct.");
            } else if (guessNum > guess) {
                System.out.println("Go down");
            }
            else if (guessNum < guess) {
                System.out.println("Go up");
            }

        } while (guessNum != guess);

        }
    }


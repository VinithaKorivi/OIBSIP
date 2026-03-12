package NumberGuessing;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int rounds = 3; 

        System.out.println("🎮Welcome to the Number Guessing Game!");
        System.out.println("👉 Enter 0 anytime to EXIT the game.");

        for (int round = 1; round <= rounds; round++) {

            System.out.println("\n🎯 Round " + round);

            int numberToGuess = random.nextInt(100) + 1;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.println("\nAttempt " + attempt + " of " + maxAttempts);
                System.out.print("Enter your guess (1-100) or 0 to exit: ");

                int userGuess = sc.nextInt();

                // Exit condition
                if (userGuess == 0) {
                    System.out.println("\n🚪 Exiting the game...");
                    System.out.println("🏆 Your Final Score: " + totalScore);
                    sc.close();
                    return;
                }

                if (userGuess == numberToGuess) {

                    System.out.println("✅ Correct! You guessed the number.");

                    int points = (maxAttempts - attempt + 1) * 10;
                    totalScore += points;

                    System.out.println("⭐ You earned " + points + " points!");
                    guessedCorrectly = true;
                    break;

                } else if (userGuess > numberToGuess) {
                    System.out.println("📉 Too High!");
                } else {
                    System.out.println("📈 Too Low!");
                }

                System.out.println("Remaining attempts: " + (maxAttempts - attempt));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You lost this round!");
                System.out.println("The correct number was: " + numberToGuess);
            }

            System.out.println("🏅 Score after Round " + round + ": " + totalScore);
        }

        System.out.println("\n🏆 Game Over!");
        System.out.println("🎯 Your Final Score: " + totalScore);

        sc.close();
    }
}
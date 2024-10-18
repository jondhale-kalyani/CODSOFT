import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
public class Game {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int score = 0;
		boolean playAgain = true;

		while (playAgain) {
			int numberToGuess = random.nextInt(100) + 1;
			int attempts = 0;
			int maxAttempts = 10;

			System.out.println("\nWelcome to the Number Guessing Game!");
			System.out.println("I have generated a number between 1 and 100.");
			System.out.println("You have " + maxAttempts + " attempts to guess it.");

			while (attempts < maxAttempts) {
				System.out.print("Enter your guess: ");
				int guess = scanner.nextInt();
				attempts++;

				if (guess < 1 || guess > 100) {
					System.out.println("Please guess a number within the range of 1 to 100.");
					attempts--; // Do not count invalid attempts
					continue;
				}

				if (guess < numberToGuess) {
					System.out.println("Too low! Try again.");
				} else if (guess > numberToGuess) {
					System.out.println("Too high! Try again.");
				} else {
					System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts
							+ " attempts.");
					score++;
					break;
				}
			}

			if (attempts == maxAttempts) {
				System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess + ".");
			}

			System.out.print("Do you want to play again? (yes/no): ");
			String response = scanner.next().toLowerCase();
			playAgain = response.equals("yes");
		}

		System.out.println("Your total score: " + score);
		scanner.close();
	}
}
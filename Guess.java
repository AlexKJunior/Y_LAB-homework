import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) throws Exception {
        int number = new Random().nextInt(100);
        int maxAttempts = 10;
        System.out.println("Я загадал число. У тебя " + maxAttempts + " попыток угадать.");
        Scanner input = new Scanner(System.in);
        int userNumber = 0;
        do {
            if (maxAttempts <= 10 && maxAttempts > 0) {
                maxAttempts--;
                System.out.print("Введите ваше число: ");
                userNumber = input.nextInt();
                if (userNumber > number)
                    System.out.println("Моё число меньше! У тебя осталось " + maxAttempts + " попыток");
                else if (userNumber < number)
                    System.out.println("Моё число больше! У тебя осталось " + maxAttempts + " попыток");
                else System.out.println("Ты угадал с " + (10 - maxAttempts) + " попытки");
            } else {
                System.out.println("Ты не угадал");
                break;
            }
        } while (userNumber != number);
    }
}
import java.util.Locale;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String gameChoice;
        int level;
        String language;

        boolean gameIsOn = true;
        boolean inputCHeck = true;


        while (gameIsOn) {

            System.out.print("начать игру? да / нет :");
            gameChoice = scanner.next();
            if (gameChoice.contains("нет".toLowerCase().trim())) {
                gameIsOn = false;
                break;
            } else if (gameChoice.contains("да".toLowerCase().trim())) {

                while (inputCHeck) {

                    System.out.print("выбери язык рус / анг:");
                    language = scanner.next().toLowerCase().trim();

                    System.out.print("выбери уровень сложности 1 / 2 / 3 :");
                    level = scanner.nextInt();

                    if ((language.contains("рус") || language.contains("анг")) && (level == 1 || level == 2 || level == 3)) {

                        ReadFile readfile = new ReadFile();
                        String word = readfile.returnWordsFromFile(language, level);

                        Game game = new Game(word);
                        game.playGame(scanner);

                        inputCHeck = false;
                    } else {
                        System.out.println("ошибка ввода языка или уровня сложности");
                    }
                }


            } else {
                System.out.println("ошибка ввода");
            }

            inputCHeck = true;


        }


        scanner.close();


    }
}
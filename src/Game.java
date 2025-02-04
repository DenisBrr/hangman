import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private int live = 8;
    boolean guessed = false;
    String emptyWord = "";
    char guessLetter;

    ArrayList<Character> wordState = new ArrayList<>();
    private String word;


    public Game(String word) {
        this.word = word;
    }


    public void playGame(Scanner scanner) {

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }
        System.out.println(wordState);
        System.out.println("game " + word);
        while (live > 0) {

            System.out.print("введи букву: ");
            guessLetter = scanner.next().toLowerCase().charAt(0);


            for (int i = 0; i < wordState.size(); i++) {
                if (word.charAt(i) == guessLetter) {
                    wordState.set(i, guessLetter);
                    guessed = true;
                }
            }
            if (!guessed) {
                live--;
            }
            guessed = false;
            printState(wordState, live);


            if (!wordState.contains('_')) {
                System.out.println("победа!");
                live = 0;
            }


        }
    }

    private void printState(ArrayList wordState, int live) {
        for (Object c : wordState) {
            System.out.print(c + " ");
        }
        System.out.println("осталось жизней: " + live);
        System.out.println(returnState(live));

    }


    public String returnState(int live) {

        switch (live) {
            case 8 -> {
                return " ";
            }
            case 7 -> {
                return """  
                          _______
                          |
                          |
                          |
                          |
                        __|__
                            """;
            }
            case 6 -> {
                return """  
                          _______
                          |     |
                          |
                          |
                          |
                        __|__
                            """;

            }
            case 5 -> {
                return """  
                          _______
                          |     |
                          |     o
                          |
                          |
                        __|__
                            """;

            }
            case 4 -> {
                return """  
                          _______
                          |     |
                          |     o
                          |     |
                          |
                        __|__
                            """;

            }
            case 3 -> {
                return """  
                          _______
                          |     |
                          |     o/
                          |     |
                          |
                        __|__
                            """;

            }
            case 2 -> {
                return """  
                          _______
                          |     |
                          |    \\o/
                          |     |
                          |
                        __|__
                            """;

            }
            case 1 -> {
                return """  
                          _______
                          |     |
                          |    \\o/
                          |     |
                          |      \\
                        __|__
                            """;

            }
            case 0 -> {
                return """  
                          _______
                          |     |
                          |   \\xox/
                          |     |
                          |    / \\
                        __|__
                            """;

            }

            default -> {
                return "incorrect input";
            }

        }


    }

}

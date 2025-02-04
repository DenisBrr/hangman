import java.io.*;
import java.util.Random;


public final class ReadFile {

    final private String pathEngLvl1 = "resources/engLevel1.txt";
    final private String pathEngLvl2 = "resources/engLevel2.txt";
    final private String pathEngLvl3 = "resources/engLevel3.txt";
    final private String pathRusLvl1 = "resources/rusLevel1.txt";
    final private String pathRusLvl2 = "resources/rusLevel2.txt";
    final private String pathRusLvl3 = "resources/rusLevel3.txt";

    Random random = new Random();

    public String returnWordsFromFile(String lang, int lvl) {
        String language = (lang.contains("рус")) ? "rus" : "eng";
        String path = "resources/" + language + "Level" + lvl + ".txt";
        String text = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text += line;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] list = text.split(" ");
        String word = list[random.nextInt(0, list.length)];


        return word;


    }


}

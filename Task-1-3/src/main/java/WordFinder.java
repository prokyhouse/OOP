
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordFinder {

    /**
     * @param file our file
     * @param word word or letter to find
     * @return postiton in file
     * @throws IOException to avoid troubles with input
     */
    public static String findWord(String file, String word) throws IOException {

        String answer = "";

        //Так как мы создаем список строк, давайте сделаем начала файла точкой отсчета для всех строк.
        int fileIndex = 0;
        List<String> lines = Files.readAllLines(Paths.get(file), Charset.defaultCharset());
        for (String x : lines) {
            //обработка всех строк как нам нужно
            if (x.contains(word)) {
                fileIndex = fileIndex + x.indexOf(word);
                answer += fileIndex + " ";
            }
        }
        return answer;
    }
}
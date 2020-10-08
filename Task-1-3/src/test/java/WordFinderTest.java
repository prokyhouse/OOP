import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class WordFinderTest {

    @Test
    public void findWordTest1() throws IOException {
        WordFinder wf = new WordFinder();
        String testFile = "input.txt";
        String word = "пирог";
        String currentAnswer = wf.findWord(testFile,word);
        Assert.assertEquals("7 14 23 ",currentAnswer);
    }
    @Test
    public void findWordTest2() throws IOException {
        WordFinder wf = new WordFinder();
        String testFile = "input.txt";
        String word = "Я";
        String currentAnswer = wf.findWord(testFile,word);
        Assert.assertEquals("0 0 ",currentAnswer);
    }
    @Test
    public void findWordTest3() throws IOException {
        WordFinder wf = new WordFinder();
        String testFile = "input.txt";
        String word = "такогоСловаНет";
        String currentAnswer = wf.findWord(testFile,word);
        Assert.assertEquals("",currentAnswer);
    }

    @Test
    public void testSubstringFinderForBigFiles() {
        if (!(new File("file10gb.txt").canRead())) {
            fileGenerator();
        }

        try {
            String answer = WordFinder.findWord("file10gb.txt", "StringToFind");
            System.out.println(answer);
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    public void fileGenerator() {
        FileOutputStream outputFile;
        try {
            outputFile = new FileOutputStream("file10gb.txt");

            int RANDOM_STRINGS_COUNT = 100000;
            int RANDOM_STRINGS_LENGTH = 100000;
            for (int i = 0; i < RANDOM_STRINGS_COUNT; i++) {
                outputFile.write(getRandomStringOfLengthN(RANDOM_STRINGS_LENGTH).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRandomStringOfLengthN(int n) {

        Random random = new Random();
        int number = random.nextInt(100);
        if (number > 95) {
            return "StringToFind";
        }

        String stringAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int) (stringAlphabet.length() * Math.random());
            sb.append(stringAlphabet.charAt(index));
        }

        return sb.toString();
    }
}




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
        Assert.assertEquals("7 ",currentAnswer);
    }
    @Test
    public void findWordTest2() throws IOException {
        WordFinder wf = new WordFinder();
        String testFile = "input.txt";
        String word = "п";
        String currentAnswer = wf.findWord(testFile,word);
        Assert.assertEquals("7 ",currentAnswer);
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
    public void findWordTest4() throws IOException {
        WordFinder wf = new WordFinder();
        String testFile = "input.txt";
        String word = "и";
        String currentAnswer = wf.findWord(testFile,word);
        Assert.assertEquals("8 13 ",currentAnswer);
    }

    @Test
    public void testSubstringFinderForBigFiles() {
        if (!(new File("bigFile.txt").canRead())) {
            fileGenerator();
        }

        try {
            WordFinder wf = new WordFinder();
            String currentAnswer = wf.findWord("bigFile.txt", "StringToFind");
            System.out.println(currentAnswer.length());
            System.out.println(currentAnswer);
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    int count = 3000;
    public void fileGenerator() {
        FileOutputStream outputFile;
        try {
            outputFile = new FileOutputStream("bigFile.txt");

            for (int i = 0; i < count; i++) {
                outputFile.write(getRandomStringOfLengthN(count).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRandomStringOfLengthN(int n) {
        final Random random = new Random();
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
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

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
}
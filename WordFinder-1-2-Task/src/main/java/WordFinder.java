
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.lang.*;
import java.io.*;

public class WordFinder {

    public static String findWord(String file, String word) throws IOException {

        final int BUF_LENGTH = 100000;
        String answer = "";
        int fileIndex;

        char[] buf = new char[BUF_LENGTH];
        char[] subBuf = new char[BUF_LENGTH];
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int numRead = reader.read(buf,0,word.length());
        String readData = String.valueOf(buf, 0, word.length());

        while ((numRead=reader.read(buf,word.length(),BUF_LENGTH-word.length())) != -1 ) {

                readData += String.valueOf(buf, word.length(), BUF_LENGTH-word.length());

            int offset = 0;

            while (offset<numRead && String.valueOf(buf, offset, BUF_LENGTH-word.length()-offset).contains(word)) {
                fileIndex = readData.indexOf(word, offset);
                offset = fileIndex + 1;
                if (!(answer.contains(Integer.toString(fileIndex))))
                answer += fileIndex + " ";
            }

            if (numRead == BUF_LENGTH){
                String newData = readData.substring(BUF_LENGTH-word.length(),BUF_LENGTH);
                readData = readData.substring(0,BUF_LENGTH-word.length());
                newData = newData.concat(readData);
                buf = newData.toCharArray();
            }

            //fileData.append(readData);
        }
        reader.close();

        return answer;
    }


}


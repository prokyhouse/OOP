
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

        String answer = "";
        int fileIndex;

        char[] buf = new char[10000000];
        char[] subBuf = new char[10000000];
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int numRead = reader.read(buf,0,buf.length);
        String readData = String.valueOf(buf, 0, word.length());

        while (numRead != -1 ) {

                readData += String.valueOf(buf, word.length(), numRead-word.length());

            int offset = 0;

            while (offset<numRead && String.valueOf(buf, offset, numRead-offset).contains(word)) {
                fileIndex = readData.indexOf(word, offset);
                offset = fileIndex + 1;
                answer += fileIndex + " ";
            }
            int k = 0;

            for (int i = buf.length-word.length();i<buf.length;i++){
                buf[k] = buf[i];
                k++;
            }

            numRead = reader.read(subBuf,0,subBuf.length-word.length());

            for(int i = 0;i<subBuf.length-word.length();i++){
                buf[i+word.length()] = subBuf[i];
            }
            fileData.append(readData);
        }
        reader.close();

        return answer;
    }


}



import java.io.*;
import java.lang.*;
import java.nio.charset.StandardCharsets;


public class WordFinder {

    /**
     * @param file is local filepath .
     * @param word is substring to find in file.
     * findWord @return answer in string "index_1 index_2 ... etc".
     *
     * @numRead - how much BR can read.
     * @offset is using to skip "previous buffer" in the beginning of readData.
     * @searchOffset helps to find following substrings in the file (when we have 2 or more SS. in one buffer iteration).
     * @substringIndex is full index of substring starting the file.
     * @bufferShift tracks buffer's iteration.
     *
     * @throws IOException
     */
    public static String findWord(String file, String word) throws IOException {

        final int BUF_LENGTH = 100000;
        char[] buf = new char[BUF_LENGTH];
        String answer = "";
        int substringIndex = 0;
        int numRead;
        int offset = 0;
        int bufferShift = 0;
        String readData = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8), BUF_LENGTH);

        while ((numRead = reader.read(buf)) != -1) {
            if (readData == null) {
                readData = String.valueOf(buf, offset, numRead);
            } else {
                readData = readData.concat(String.valueOf(buf, offset, numRead - offset));
            }
            int searchOffset = 0;
            while (String.valueOf(buf, searchOffset, numRead - searchOffset).contains(word)) {
                substringIndex = readData.indexOf(word.charAt(0), searchOffset);
                searchOffset = substringIndex + word.length();
                int finalSubstringIndex = substringIndex + bufferShift;
                answer += finalSubstringIndex + " ";
            }
            readData = readData.substring(numRead - word.length(), numRead);
            offset = word.length();
            bufferShift += numRead;
        }
        reader.close();
        return answer;
    }
}


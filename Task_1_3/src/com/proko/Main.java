package com.proko;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main extends WordFinder{

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        //Считываем
        String file = in.nextLine(); //Название файла
        String word = in.nextLine(); //Искомое слово

                System.out.println(findWord(file,word));

    }
}

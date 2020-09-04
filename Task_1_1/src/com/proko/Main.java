package com.proko;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends HeapSort {

    public static void main(String[] args) {

        //Создаем ArrayList для считывания строки (мы не знаем ее размер)
        ArrayList arr = new ArrayList();
        Scanner in = new Scanner(System.in);
        //Считываем
        String input = in.nextLine();
        //Удаляем ненужные "{" и "}"
        String arrayString = input.replaceAll("\\{|\\}", "");
        //Парсим строку с запятыми и извлекаем числа в arr
        for (String retval : arrayString.split(",", 100000)) {
            try {
                arr.add(Integer.parseInt(retval));
            } catch (NumberFormatException e) {
                System.out.print("Число "+retval+" больше допустимого значения INT.\nМассив был отсортирован без учета данного числа.\n");
            e.printStackTrace();
            }
        }
        //Переносим данные из безразмерного ArrayList в массив
        int[] arrToSort = convertIntegers(arr);

        //создаем объект класса и сортируем
        HeapSort ob = new HeapSort();
        ob.sort(arrToSort);

        //Выводим в спомогательной функции
        printArray(arrToSort);
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int arr[]) {
        int n = arr.length;
        System.out.print("{");
        int counter = 0;
        for (int j = 0; j < arr.length -1; j++) {
            System.out.print(arr[j] + ",");
            counter++;
        }
        System.out.print(arr[counter]);

        System.out.print("}\n");
    }

    //Код из интернета для конвертации массива
    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }
}

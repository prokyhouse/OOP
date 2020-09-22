package com.proko;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main extends HeapSort {

    public static void main(String[] args) {

        ArrayList arr = new ArrayList();
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        String arrayString = input.replaceAll("\\{|\\}", "");

        for (String retval : arrayString.split(",", 100000)) {
            try {
                arr.add(Integer.parseInt(retval));
            } catch (NumberFormatException e) {
                System.out.print("Число "+retval+" больше допустимого значения INT.\nМассив был отсортирован без учета данного числа.\n");
            e.printStackTrace();
            }
        }

        int[] arrToSort = convertIntegers(arr);

        HeapSort ob = new HeapSort();
        ob.sort(arrToSort);

        printArray(arrToSort);
    }

    /**
     * @param arr array to print
     */


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

    /**
     * @param integers List to convert
     * @return converted array
     */

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }
}

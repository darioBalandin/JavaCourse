package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size");
        int num = scanner.nextInt();
        int[] arr = getIntegers(num);


        System.out.println(Arrays.toString(arr));


//        int[] ramArr=Main.getRandomArray(8);
//
//        System.out.println(Arrays.toString(ramArr));
//
//        int[] copy=Arrays.copyOf(ramArr, ramArr.length);
//
//        Arrays.sort(copy);
//        System.out.println(Arrays.toString(ramArr));
//        System.out.println(Arrays.toString(copy));
//
//        Arrays.fill(copy, 0);
//        System.out.println(Arrays.toString(copy));

//        String[] sArr = {"assa","zapae","renegao","beases"};
//
//        Arrays.sort(sArr);
//        System.out.println(Arrays.toString(sArr));
//
//        int inde=Arrays.binarySearch(sArr, "beases");
//        System.out.println("index es "+inde);


//        int[] ramArr = Main.getRandomArray(8);
//
//        System.out.println(Arrays.toString(ramArr));
//
//        int[] copy = Arrays.copyOf(ramArr, ramArr.length);
//
//        Arrays.sort(copy);
//
//        System.out.println(Arrays.toString(copy));
//
//        int lastIndex = copy.length - 1;
//
//        int[] reverse = new int[copy.length];
//        for (int i = 0; i < ramArr.length; i++) {
//            reverse[i] = copy[lastIndex];
//            lastIndex--;
//        }
//
//        System.out.println(Arrays.toString(reverse) + " reversed");

    }

    private static int[] getIntegers(int len){


        Scanner scanner = new Scanner(System.in);

        int[] newInt = new int[len];

        for (int i = 0; i < len; i++) {

            System.out.println("Enter a number");
            newInt[i] = scanner.nextInt();
        }
        return newInt;
    }

    private static void printArray(int[] arr) {

        for(int i=0;i<arr.length;i++){
            System.out.println("Element " + i+ "contents "+ arr[i]);
        }
    }
    private static int[] sortIntegers(int[] arr){

        int lastIndex = arr.length - 1;

        int[] copy= Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        int[] reverse = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverse[i] = copy[lastIndex];
            lastIndex--;
        }

        return reverse;


    }


    private static int[] getRandomArray(int len) {

        Random random = new Random();

        int[] newInt = new int[len];

        for (int i = 0; i < len; i++) {

            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
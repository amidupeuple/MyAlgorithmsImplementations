package com.danyapivovarov.algo.impls;

import com.danyapivovarov.algo.utils.DataGenerator;

/**
 * Created by dpivovar on 29.06.2016.
 */
public class BubbleSort extends AbstractSort{
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
                counter++;
            }
        }

        return arr;
    }

    public int[] sortInTwoDirections() {
        int leftCounter = 0;

        for (int i = arr.length - 1; i > leftCounter; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }

            //second traverse - from right to left
            for (int j = i; j > leftCounter; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }

            leftCounter++;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = DataGenerator.prepareIntegerArray(100000);
        int[] arr1 = new int[100000];
        System.arraycopy(arr, 0, arr1, 0, arr.length);

        BubbleSort bubbleSort = new BubbleSort(arr);
        BubbleSort bubbleSort1 = new BubbleSort(arr1);

        long startBubble = System.currentTimeMillis();
        bubbleSort.sort();
        System.out.println("Simple bubble: " + (System.currentTimeMillis() - startBubble));
        System.out.println(bubbleSort.arrayToString());

        long startBubble1 = System.currentTimeMillis();
        bubbleSort1.sortInTwoDirections();
        System.out.println("Two-directions bubble: " + (System.currentTimeMillis() - startBubble1));
        System.out.println(bubbleSort1.arrayToString());
    }
}

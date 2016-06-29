package com.danyapivovarov.algo.impls;

import com.danyapivovarov.algo.utils.DataGenerator;

/**
 * Created by dpivovar on 29.06.2016.
 */
public class OddEvenSort extends AbstractSort{

    public OddEvenSort(int[] arr) {
        this.arr = arr;
    }

    private int counterOfWhile = 0;
    private int counterOfFor = 0;

    @Override
    public int[] sort() {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int l = 1; l < arr.length - 1; l += 2) {
                if (arr[l] > arr[l + 1]) {
                    int temp = arr[l + 1];
                    arr[l + 1] = arr[l];
                    arr[l] = temp;
                    sorted = false;
                }
            }

            counterOfFor++;

            for (int m = 0; m < arr.length-1; m += 2) {
                if (arr[m] > arr[m + 1]) {
                    int temp = arr[m + 1];
                    arr[m + 1] = arr[m];
                    arr[m] = temp;
                    sorted = false;
                }
            }
            counterOfFor++;

            counterOfWhile++;
        }

        return arr;
    }

    private boolean isArrSorted() {
        for (int k = 0; k < arr.length - 1; k++) {
            if (arr[k] > arr[k+1]) {
                return false;
            }
        }
        return true;
    }

    public int getCounterOfWhile() {
        return counterOfWhile;
    }

    public int getCounterOfFor() {
        return counterOfFor;
    }

    public static void main(String[] args) {
        int max = 10;
        int[] arr = DataGenerator.prepareIntegerArray(max);
        int[] arr1 = new int[max];
        System.arraycopy(arr, 0, arr1, 0, max);

        OddEvenSort oddEvenSort = new OddEvenSort(arr);
        System.out.println(oddEvenSort.arrayToString());
        oddEvenSort.sort();
        System.out.println(oddEvenSort.arrayToString());
        System.out.println("while: " + oddEvenSort.getCounterOfWhile() + " | for: " + oddEvenSort.getCounterOfFor());

        BubbleSort bubbleSort = new BubbleSort(arr1);
        System.out.println(bubbleSort.arrayToString());
        bubbleSort.sort();
        System.out.println(bubbleSort.arrayToString());
        System.out.println("counter: " + bubbleSort.getCounter());
    }
}

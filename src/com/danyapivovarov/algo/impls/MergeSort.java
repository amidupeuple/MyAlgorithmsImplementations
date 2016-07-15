package com.danyapivovarov.algo.impls;

import com.danyapivovarov.algo.utils.DataGenerator;

/**
 * Created by dpivovar on 08.07.2016.
 */
public class MergeSort extends AbstractSort{

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int[] sort() {
        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length - left.length];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, left.length, right, 0, right.length);

        arr = mergeSort(left, right);
        return arr;
    }

    private int[] mergeSort(int[] arr1, int[] arr2) {
        if (arr1.length == 1 || arr2.length == 1) {
            int[] result = merge(arr1, arr2);
            return result;
        } else {
            int[] left = new int[arr1.length/2];
            int[] right = new int[arr1.length - left.length];
            System.arraycopy(arr1, 0, left, 0, left.length);
            System.arraycopy(arr1, left.length, right, 0, right.length);
            arr1 = mergeSort(left, right);

            int[] left2 = new int[arr2.length/2];
            int[] right2 = new int[arr2.length - left2.length];
            System.arraycopy(arr2, 0, left2, 0, left2.length);
            System.arraycopy(arr2, left.length, right2, 0, right2.length);
            arr2 = mergeSort(left2, right2);

            return merge(arr1, arr2);
        }
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i1, i2, i;
        i1 = i2 = i = 0;

        while (i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1] > arr2[i2]) {
                result[i] = arr2[i2];
                i2++;
            } else {
                result[i] = arr1[i1];
                i1++;
            }
            i++;
        }

        while (i1 < arr1.length) {
            result[i] = arr1[i1];
            i1++;
            i++;
        }

        while (i2 < arr2.length) {
            result[i] = arr2[i2];
            i2++;
            i++;
        }

        return result;
    }

    public void recMergeSortBook(int[]workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSortBook(workSpace, lowerBound, mid);
            recMergeSortBook(workSpace, mid+1, upperBound);
            mergeBook(workSpace, lowerBound, mid+1, upperBound);
        }
    }

    private void mergeBook(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; //number of elements

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (arr[lowPtr] < arr[highPtr]) {
                workSpace[j++] = arr[lowPtr++];
            } else {
                workSpace[j++] = arr[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            workSpace[j++] = arr[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = arr[highPtr++];
        }

        for (j = 0; j < n; j++) {
            arr[lowerBound+j] = workSpace[j];
        }
    }


    public static void main(String[] args) {
        int n = 8;
        MergeSort mergeSort = new MergeSort(DataGenerator.prepareIntegerArray(n));
        mergeSort.recMergeSortBook(new int[n], 0, n-1);
        System.out.println(mergeSort.arrayToString());
    }
}

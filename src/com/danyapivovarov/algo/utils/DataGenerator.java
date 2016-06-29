package com.danyapivovarov.algo.utils;

import java.util.Random;

/**
 * Created by dpivovar on 29.06.2016.
 */
public class DataGenerator {

    public static int[] prepareIntegerArray(int size) {
        int[] result = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(100);
        }

        return result;
    }

    public static long[] prepareLongArray(int size) {
        long[] result = new long[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(100);
        }

        return result;
    }
}

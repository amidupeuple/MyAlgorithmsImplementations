package com.danyapivovarov.exercises;

import com.danyapivovarov.algo.utils.ReadFromConsoleUtil;

import java.io.IOException;

/**
 * Created by dpivovar on 14.07.2016.
 */
public class RecursionPowerTask {
    private int x;
    private int y;

    public RecursionPowerTask(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter X: ");
        int x = ReadFromConsoleUtil.getInt();
        System.out.print("Enter Y: ");
        int y = ReadFromConsoleUtil.getInt();

        RecursionPowerTask task = new RecursionPowerTask(x, y);
        int result = task.makePower(task.x, task.y);
        System.out.println("X^Y = " + result);
    }

    private int makePower(int x, int y) {
        if (y == 1) {
            return x;
        }

        return makePower(x * x, y / 2);
    }
}

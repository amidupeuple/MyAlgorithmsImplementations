package com.danyapivovarov.exercises;

/**
 * Created by dpivovar on 15.07.2016.
 */
public class PackBagTask {
    private int[] items;
    private int[] usedIndexes;
    private final int max;

    public PackBagTask(int[] items, int max) {
        this.items = items;
        this.max = max;

        usedIndexes = new int[items.length];
    }

    public int[] findCombination() {
        int[] result = null;

        for (int i = 0; i < items.length; i++) {
            result = packBag(items[i], i, 0);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    private int[] packBag(int weight, int curIndex, int counter) {
        /*if (weight == max) {
            return usedIndexes;
        } else if (weight < max) {
            usedIndexes[counter++] = curIndex;
            if (curIndex < items.length - 1) {
                curIndex++;
                return packBag(weight + items[curIndex], curIndex, counter);
            } else {
                return null;
            }
        } else if (weight > max) {
            if (curIndex < items.length - 1) {
                curIndex++;
                return packBag(weight, curIndex, counter);
            } else {
                curIndex = usedIndexes[]
                for ()
            }
        }*/

        return null;
    }


    public static void main(String[] args) {
        PackBagTask task = new PackBagTask(new int[]{8, 1, 7, 2, 9}, 20);
        task.findCombination();
    }
}

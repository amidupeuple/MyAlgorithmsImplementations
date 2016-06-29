package com.danyapivovarov.algo.impls;

/**
 * Created by dpivovar on 29.06.2016.
 */
public abstract class AbstractSort {
    protected int[] arr;

    public abstract int[] sort();

    public String arrayToString() {
        StringBuffer buf = new StringBuffer();
        for (int i: arr) {
            buf.append(i + ", ");
        }

        return buf.substring(0, buf.length() - 2);
    }
}

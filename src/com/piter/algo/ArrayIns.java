package com.piter.algo;

import com.danyapivovarov.algo.utils.DataGenerator;

import java.awt.*;
import java.util.Random;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------
    public void insertionSort()
    {
        int in, out;

        for(out=1; out<nElems; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
            in = out;                      // start shifts at out
            while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
                a[in] = a[in-1];            // shift item to right
                --in;                       // go left one position
            }
            a[in] = temp;                  // insert marked item
        }  // end for
    }  // end insertionSort()

    public long median() {
        insertionSort();

        return a[nElems/2];
    }

    public void setA(long[] a) {
        this.a = a;
    }

    public long[] getA() {
        return a;
    }

    public void setnElems(int nElems) {
        this.nElems = nElems;
    }

    //--------------------------------------------------------------
}  // end class ArrayIns
////////////////////////////////////////////////////////////////
class InsertSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 21;            // array size

        ArrayIns arr;                 // reference to array
        //ArrayIns arr1;

        arr = new ArrayIns(maxSize);  // create the array
        //arr1 = new ArrayIns(maxSize);
        arr.setnElems(maxSize);
        //arr1.setnElems(maxSize);

        long[] a = DataGenerator.prepareLongArray(maxSize);
        //long[] a1 = new long[maxSize];
        //System.arraycopy(a, 0, a1, 0, maxSize);

        arr.setA(a);
        //arr1.setA(a1);

        arr.display();
        arr.insertionSort();
        arr.display();
        System.out.println("Median: " + arr.median());


        /*long simpleWay = System.currentTimeMillis();
        arr.insertionSort();
        System.out.println("Simple time: " + (System.currentTimeMillis() - simpleWay) + " | Median: " + arr.getA()[(maxSize-1)/2]);

        long medianWay = System.currentTimeMillis();
        long median = arr1.median();
        System.out.println("Median time: " + (System.currentTimeMillis() - medianWay) + " | Median: " + median);*/
    }  // end main()
}  // end class InsertSortApp


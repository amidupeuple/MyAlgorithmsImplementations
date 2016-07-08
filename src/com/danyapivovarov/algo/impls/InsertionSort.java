package com.danyapivovarov.algo.impls;

/**
 * Created by dpivovar on 29.06.2016.
 */
public class InsertionSort extends AbstractSort {
    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        int temp, inner, outer;

        for (outer = 1; outer < arr.length; outer++) {
            temp = arr[outer];

            for (inner = outer - 1; inner >= 0; inner--) {
                if (arr[inner] > temp) {
                    arr[inner + 1] = arr[inner];

                    if (inner == 0) {
                        arr[inner] = temp;
                    }
                } else {
                    arr[inner + 1] = temp;
                    break;
                }
            }
        }

        return arr;
    }

    public int[] sortWithoutDuplicates() {
        int temp, inner, outer;

        for (outer = 1; outer < arr.length; outer++) {
            temp = arr[outer];

            for (inner = outer - 1; inner >= 0; inner--) {
                if (arr[inner] > temp) {
                    arr[inner + 1] = arr[inner];

                    if (inner == 0) {
                        arr[inner] = temp;
                    }
                }else if (arr[inner] == temp) {
                    temp = -1;
                    arr[inner + 1] = arr[inner];
                    if (inner == 0) {
                        arr[inner] = temp;
                    }
                } else if (arr[inner] < temp) {
                    arr[inner + 1] = temp;
                    break;
                }
            }
        }

        int[] newArr = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > -1) {
                newArr = new int[arr.length - i];
                System.arraycopy(arr, i, newArr, 0, newArr.length);
                arr = newArr;
                break;
            }
        }

        return newArr;
    }

    public int[] sortBook()
    {
        int in, out;
        for(out=1; out<arr.length; out++) // out - разделительный маркер
        {
            int temp = arr[out]; // Скопировать помеченный элемент
            in = out; // Начать перемещения с out
            while(in>0 && arr[in-1] >= temp) // Пока не найден меньший элемент
            {
                arr[in] = arr[in-1]; // Сдвинуть элемент вправо
                --in; // Перейти на одну позицию влево
            }
            arr[in] = temp; // Вставить помеченный элемент
        }

        return arr;
    }




    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort(new int[]{9, 8, 7, 0, 5, 0, 3});
        System.out.println(insertionSort.arrayToString());
        insertionSort.sortWithoutDuplicates();
        System.out.println(insertionSort.arrayToString());
    }
}

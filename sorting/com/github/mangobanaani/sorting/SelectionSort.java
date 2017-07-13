package com.github.mangobanaani.sorting;

/**
 * Created by mangobanaani on 13/07/2017.
 */

public class SelectionSort {

    public int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {         // go through the array
            int min = i;                             // init minimum to fist item
            for (int j = i + 1; j < a.length; j++) { // the next items
                if (a[j] < a[min]) {                 // if smaller than we begin with
                    min = j;                         // new minimum
                }
                this.swap(a, i, j);                  // swap items in array
            }
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}


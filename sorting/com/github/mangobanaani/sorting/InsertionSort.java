package com.github.mangobanaani.sorting;

/**
 * Created by pekka on 13/07/2017.
 */
public class InsertionSort {

    public int[] sort(int[] a)
    {
        for (int i = 1; i < a.length; i++)              // for each i-> 1..n-1
        {
            for (int j=i; j>0 && (a[j]<a[j-1]); j--)    // swap a[i] when > a[0]
                swap(a,j,j-1);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}

package com.github.mangobanaani.sorting;

/**
 * Created by mangobanaani on 13/07/2017.
 */

public class ShellSort {

    public int[] sort(int[] a)
    {
        int h = 1;
        while (h<a.length/3){
            h=3*h+1;
        }
        while (h>=1)
        {
            for (int i=h; i<a.length; i++)
            {
                for (int j=i; j >= h && a[j]<a[j-h]; j-=h)
                    this.swap(a,j,j-h);
            }
            h=h/3;
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}

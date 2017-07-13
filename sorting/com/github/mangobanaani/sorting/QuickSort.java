package com.github.mangobanaani.sorting;

/**
 * Created by pekka on 13/07/2017.
 */
public class QuickSort {

    public int[] sort(int[] a){
        this.sort(a,0,a.length-1);
        return a;
    }

    private void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = this.partition(a, lo, hi);
        sort(a, lo, j - 1);         // left side
        sort(a, j + 1, hi);         // right side
    }

    private int partition(int[] a, int lo, int hi) {
        int i=lo;
        int j=hi+1;
        int v=a[lo];
        while(true){
            while (a[++i]<v){
                if(i==hi){
                    break;
                }
            }
            while(v<a[--j]){
                if(j==lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
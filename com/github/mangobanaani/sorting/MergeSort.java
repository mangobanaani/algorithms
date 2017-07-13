package com.github.mangobanaani.sorting;

/**
 * Created by mangobanaani on 13/07/2017.
 */

public class MergeSort {

    private static int[] tmp;

    public int[] sort(int[] a)
    {
        this.tmp = new int[a.length];
        sort(a,0,a.length-1);
        return a;
    }

    private void sort(int[] a, int lo, int hi)
    {
        if(hi<=lo)
            return;
        int mid=lo+(hi-lo)/2;       // midpoint
        sort(a,lo,mid);             // left side
        sort(a,mid+1,hi);       // right side
        merge(a,lo,mid,hi);         // merge
    }

    public void merge(int[] a, int lo, int mid, int hi)
    {
        int i=lo;                       // left side
        int j=mid+1;                    // right side of midpoint
        for (int k=lo; k<=hi; k++) {    // left side copy to tmp
            tmp[k]=a[k];
        }
        for (int k=lo; k<=hi; k++)      // merge back
            if(i > mid){
                a[k] = tmp[j++];
            } else if(j>hi){
                a[k] = tmp[i++];
            }else if(tmp[j]<tmp[i]){
                a[k] = tmp[j++];
            }else{
                a[k] = tmp[i++];
            }
    }
}

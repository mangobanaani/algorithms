package com.github.mangobanaani.sorting.tests;

import com.github.mangobanaani.sorting.ShellSort;
import org.junit.Test;
import static org.junit.Assert.*;
import com.github.mangobanaani.sorting.MergeSort;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by mangobanaani on 13/07/2017.
 */

public class MergeSortTest {
    @Test
    public void testSort() throws Exception {
        MergeSort ms = new MergeSort();
        int[] testdata = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; // array to test with
        int[] res = ms.sort(testdata);                                // sort it out
        int[] exp = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};      // expected result
        assertArrayEquals(res, exp);                                   // compare
    }


}

package com.github.mangobanaani.sorting.tests;

import com.github.mangobanaani.sorting.ShellSort;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by mangobanaani on 13/07/2017.
 */

public class ShellSortTest {
    @Test
    public void testSort() throws Exception {
        ShellSort shs = new ShellSort();
        int[] testdata = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; // array to test with
        int[] res = shs.sort(testdata);                                // sort it out
        int[] exp = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};      // expected result
        assertArrayEquals(res, exp);                                   // compare
    }


}

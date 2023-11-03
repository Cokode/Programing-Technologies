package eigthweek;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSortBugFixed {

    private static final Logger LOGGER = Logger.getLogger(MergeSortBugFixed.class.getName());

    public static int[] sort(int[] array) {
        if(array != null && array.length > 1)
            return sort(array, 0, array.length-1);
        return array;
    }

    /**
     *
     * @param array This Method takes an array of positive Integers, from the parameter
     *              returns the array if the length of array is == 1.
     * @param from  From marks the beginning of the array indices, Index 0;
     * @param to    `To` points to the end of the array, i.e. the last element of the array.
     * @return      `return` returns an array value each time a condition is fulfilled.
     *
     * The bug in the Original mergeSort Method was in line 30.
     * line 35 recursively calls itself and should take `m` as the new `to',
     * `m-1` plugs in the wrong index as we try to half through the array till halving is no more possible.
     */
    public static int[] sort(int[] array, int from, int to) {
        LOGGER.info("Calling sort Method ");

        if (from >= to || array.length == 1) {
            return new int[] {array[from] };
        }

        int m = (from + to) / 2;
        int[] left = sort(array, from, m);
        int[] right = sort(array, m+1, to);

        int[] result = new int[left.length + right.length];
        int li = 0;
        int ri = 0;

        try {
            for (int i = 0; i < result.length; i++) {
                if (li < left.length && (ri >= right.length || left[li] < right[ri])) {
                    result[i] = left[li];
                    li++;
                } else {
                    result[i] = right[ri];
                    ri++;
                }
            }
        } catch (IndexOutOfBoundsException exception) {
            LOGGER.log(Level.WARNING, "Index out of bound here ", exception);
        }

        return result;
    }

    public static boolean isSorted(int[] array) {
        boolean ret = true;

        for (int i = 0 ; i < array.length-1 ; i++)
            if (array[i] > array[i+1])
                return false; // loop should terminate instead

        return ret;
    }

    public static boolean isPermutation(int[] arrayA, int[] arrayB) {
        if (arrayA.length != arrayB.length) return false;

        int []arrAsorted=arrayA;
        int []arrBsorted=arrayB;

        Arrays.sort(arrAsorted);
        Arrays.sort(arrBsorted);

        for(int i = 0; i  <  arrayA.length; i++){
            if(arrayA[i] != arrayB[i])
                return false;
        }
        return true;
    }

    public static void main(String[] arg) {
        int[] array2 = {1,2,10,4,3,7,8,5};
        System.out.println(Arrays.toString(sort(array2)));
    }
}
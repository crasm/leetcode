package us.vczf.leetcode;

public class LC4MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] aa, int[] bb) {
        // If we have an even number of elements, we have two medians that
        // must be averaged.
        boolean mustAverage = (aa.length + bb.length) % 2 == 0;

        // Calculate the index of the median. If there are an even number of
        // elements, this will be the index of the RHS of the median pair.
        int medianIndex = (aa.length + bb.length) / 2;

        // We traverse both arrays simultaneously as if it were one large array.
        // {kVals[1]} stores the value at {k} and {kVals[0]} stores {k-1}.
        // We don't store the combined sorted array, because we do not need it.
        Integer[] kVals = {null, null};

        int i = 0, j = 0; // Indices for traversing aa and bb respectively.
        int k = 0; // Index in the virtual "combined" array
        while (k <= medianIndex) {
            boolean aOk = i < aa.length;
            boolean bOk = j < bb.length;

            // Collect the next values from {aa} and {bb}, unless there are no
            // more in the array.
            Integer a = aOk ? aa[i] : null;
            Integer b = bOk ? bb[j] : null;

            // Save old value, which is now {k-1}
            kVals[0] = kVals[1];
            if (!bOk || aOk && a <= b) { // Select next value from {aa}
                kVals[1] = a;
                i++;
            } else if (!aOk || b < a) { // ...or select next value from {bb}
                kVals[1] = b;
                j++;
            } else {
                // We should never run out of elements before finding the median
                throw new IllegalStateException();
            }

            k++;
        }

        if (mustAverage) {
            return (kVals[0] + kVals[1]) / 2.0;
        } else {
            return kVals[1];
        }
    }
}

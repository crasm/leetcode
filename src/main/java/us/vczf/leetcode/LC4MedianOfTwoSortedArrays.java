package us.vczf.leetcode;

public class LC4MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] aa, int[] bb) {
        // If we have an even number of elements, we have two medians that
        // must be averaged.
        boolean mustAverage = (aa.length + bb.length) % 2 == 0;

        // Calculate the index of the median. If there are an even number of
        // elements, this will the index of the RHS of the median pair.
        int medianIndex = (aa.length + bb.length) / 2;

        // We traverse both arrays simultaneously as if it were one large array.
        // {kVals[1]} stores the value at {k} and {kVals[0]} stores {k-1}.
        // We don't store the combined sorted array, because we do not need it.
        int[] kVals = {Integer.MIN_VALUE, Integer.MIN_VALUE};

        int i = 0, j = 0; // Indices for traversing aa and bb
        int k = 0; // Index in the virtual "combined" array

        while (k <= medianIndex) {
            boolean aOk = i < aa.length;
            boolean bOk = j < bb.length;

            int a = aOk ? aa[i] : Integer.MAX_VALUE;
            int b = bOk ? bb[j] : Integer.MAX_VALUE;

            kVals[0] = kVals[1];
            if (!bOk || aOk && a <= b) {
                kVals[1] = a;
                i++;
            } else if (!aOk || b < a){
                kVals[1] = b;
                j++;
            } else {
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

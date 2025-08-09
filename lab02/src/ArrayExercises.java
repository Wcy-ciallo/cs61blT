import java.util.ArrayList;
import java.util.List;

public class ArrayExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        // TODO: Fill in this function.
        int[] a = new int[] {1, 2, 3, 4, 5, 6};
        return a;
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        // TODO: Fill in this function.
        int mx = array[0], mn = array[0];
        for(int i = 0; i < array.length; i++) {
            if(mx < array[i]) mx = array[i];
            if(mn > array[i]) mn = array[i];
        }
        int res = mx - mn;
        return res;
    }

}

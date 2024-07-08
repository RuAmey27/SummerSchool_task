import java.util.Arrays;

public class mergesort {
    public static int[] merge(int[] a, int[] b) {
        //int countshift=0;
        Integer size = Integer.max(a.length, b.length) ;
        int[] arr = new int[size];
        // int i = 0;
        // int j = 0;
        // int k = 0;
        for (int i = 0; i < arr.length; i++) {
            Arrays.binarySearch(b, a[i]);
            
        }
        // while (i < a.length && j < b.length) {
        //     if (a[i] == b[j]) {
        //         arr[k] = a[i];
        //         //countshift++;
        //         i++;
        //      }// else {
        //     //     //arr[k] = b[j];
        //     //     //countshift++;
        //     //     j++;
        //     // }
        //     k++;
        // }
        // while (i < a.length) {
        //     arr[k] = a[i];
        //     countshift++;
        //     i++;
        //     k++;
        // }

        // while (j < b.length) {
        //     arr[k] = b[j];
        //     countshift++;
        //     j++;
        //     k++;
        // }
        //System.out.println(countshift);
        return arr;
    }

    public static String toString_array(int[] a) {
        StringBuilder z = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            z.append(a[i] + " ");
        }
        return z.toString();
    }
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        int[] ans= merge(array1, array2);
        System.out.println(toString_array(ans));
    }
}



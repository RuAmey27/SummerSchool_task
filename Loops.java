import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Loops {
    int count = 0;

    public static int BinarySearch(int[] arr, int start, int end, int key) {
        int mid = (start + end) / 2;
        if (key == arr[mid]) {
            return mid;
        } else if (key < arr[mid]) {
            return BinarySearch(arr, 0, mid, key);
        } else if (key > arr[mid]) {
            return BinarySearch(arr, mid + 1, end, key);
        } else {
            return -1;
        }
    }

    
    

     int partition(int arr[], int p, int q) {

        int countswap = 0;
        int pivot = arr[q];
        int i = (p - 1); // index of smaller element
        for (int j = p; j < q; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                countswap++;
            }
        }
        System.out.println(countswap);
        // swap arr[i+1] and arr[q] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[q];
        arr[q] = temp;
        System.out.println(toString_array(arr));
        count++;
        return i + 1;
    }

     private char[] toString_array(int[] arr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString_array'");
    }




    void sort(int arr[], int p, int q) {
        
        if (p < q) {
            int index = partition(arr, p, q);

            sort(arr, p, index - 1);
            sort(arr, index + 1, q);
        }
        
    }

    public static int[] merge(int[] a, int[] b) {
        int countshift=0;
        int size = a.length + b.length;
        int[] arr = new int[size];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                arr[k] = a[i];
                countshift++;
                i++;
            } else if(a[i]!=b[j]){
                arr[k] = b[j];
                countshift++;
                j++;
            }
            k++;
        }
        while (i < a.length) {
            arr[k] = a[i];
            countshift++;
            i++;
            k++;
        }

        while (j < b.length) {
            arr[k] = b[j];
            countshift++;
            j++;
            k++;
        }
        System.out.println(countshift);
        return arr;
    }



    public static void mergen(int NoOfArray,int n,int[n]... a) {
        
         
    }


    public static void main(String[] args) {
    Loops obj=new Loops();
    Loops obj2=new Loops();
    Loops obj3=new Loops();
        //int[] array={10,20,30,40,50,60,70,80,90,100};
        int[] array = { 40, 30, 70, 100, 20, 10, 90, 35, 48, 25 };
       // Loops.toString_array(array);
        // System.out.println(BinarySearch(array,0,8,100));
        int[] arrayreverse={100,90,80,70,60,50,40,30,20,10};
        int[] tens={10,10,10,10,10,10,10,10,10,10};
        //long intial=System.nanoTime();
        obj.sort(array, 0, 9);
        //long fi=System.nanoTime();
        //System.out.println(fi-intial);
        System.out.println("--------------------------------");
        System.out.println(obj.toString_array(array));
        System.out.println("--------------------------------");
        System.out.println(obj.count);
        System.out.println("--------------------------------");
        obj2.sort(arrayreverse, 0, 9);
        System.out.println("--------------------------------");
        System.out.println(obj2.toString_array(arrayreverse));
        System.out.println("--------------------------------");
        System.out.println(obj2.count);
        System.out.println("--------------------------------");
        obj3.sort(tens, 0, 9);
        System.out.println("--------------------------------");
        System.out.println(obj3.toString_array(tens));
        System.out.println("--------------------------------");
        System.out.println(obj3.count);
        System.out.println("--------------------------------");

        // int[] array1 = {1, 2, 3, 4, 5};
        // int[] array2 = {4, 5, 6, 7, 8};
        
        // int[] ans=merge(array1, array2);
        // System.out.println(Loops.toString_array(ans));

        // int[] arr1 = {7, 8, 9, 10, 11};
        // int[] arr2 = {1, 2, 3, 4, 5};
        // int [] ans2=merge(arr1, arr2);
        // System.out.println(Loops.toString_array(ans));





        // int count=0;
        // int n=1000;
        // int i=1;
        // System.out.println((double)1000/66);
        // while (i<=n) {
        // i=i+5;
        // i=i+55;
        // i=i+6;
        // count++;
        // System.out.println("loop +" +count);
        // }

        // n=1000;
        // i=1;
        // count=0;
        // System.out.println(Math.log(1000)/Math.log(6));
        // while (i<=n) {
        // i=i*2;
        // i=i*3;
        // count++;
        // System.out.println("loop +" +count);
        // }
    }

}

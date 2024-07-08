public class QuickSort {
    public static int nthelement(int[] array, int n) {
        int nthsmallest = array.length / n;
        int smallest[] = new int[nthsmallest];
        int small = array[0];
        int j = nthsmallest - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < small) {
                small = array[i];
                smallest[j] = small;
                j--;
            }//else{

            // }
        }

        for (int i = 0; i < smallest.length; i++) {
            System.out.print(smallest[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

        return smallest[0];
    }


    public static String recurrence(String pivote, String position){
        StringBuilder relation=new StringBuilder();
        relation.append("O(");
        relation.append(pivote);
        relation.append(")");
        relation.append("+");
        relation.append("T(");
        relation.append(position);
        relation.append(")+");
        relation.append("T(");
        relation.append("1-"+position);
        relation.append(")");
        return relation.toString();
    }

    public static void main(String[] args) {

        String s="n^2";
        String s2="n/10";
        System.out.println(recurrence(s,s2));

    }
}
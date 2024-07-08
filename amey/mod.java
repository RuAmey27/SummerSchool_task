
import java.util.*;
import java.util.ArrayList;
class mod {
    public static void bin(int a){
        ArrayList<Integer> binaryDigits = new ArrayList<>();

        while (a > 0) {
            int remainder = a % 2;
            binaryDigits.add(remainder);
            a /= 2;
        }

        System.out.println(binaryDigits.size() - 1);
    }
    public static void main(String[] args) {
        
        bin(15);
        bin(16);
        bin(17);
        bin(8);
        bin(7);
        bin(9);
}
}

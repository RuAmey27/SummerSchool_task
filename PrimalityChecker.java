import java.util.ArrayList;
import java.util.List;

public class PrimalityChecker {
    public static boolean isPrime(double input){
        if(input%1!= 0){
            return false;
        }
        int n= (int)input;
        if(n<=1){
            return false;           //checks negative 
        }

        if (n > 2 && n % 2 == 0) {
            return false;           // checks even 
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;     // check the factors
                                  // operates on the O(root(input)) complexity 
            }
        }

        return true;
    }


    public static boolean areCoPrime(int a,int b){
        return gcd(a,b)==1;         //two numbers are coprimes if there gcd is 1
    }

    public static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;               // this is iterative approach to find gcd
    }

    public static List<int[]> getccPrimes(int start, int end){
        List<int[]> coPrimespairs= new ArrayList<>();
        for (int i = start; i < end; i++) {
            for(int j=i+1;j<=end; j++){
                if(areCoPrime(i, j)){
                    if(isPrime(i)&&isPrime(j)) coPrimespairs.add(new int[]{i,j});
                }
            }
            
        }
        return coPrimespairs;
    }

    public static List<int[]> getTwinPrimes(int start,int end){
        List<int[]> twinPrimes = new ArrayList<>();
        for(int i=start;i<=end-2;i++){
            if(isPrime(i)&& isPrime(i+2)){
                twinPrimes.add(new int[]{i,i+2});
            }
        }
        return twinPrimes;
    }

}

//performance check of any method of MyInteger Class
// Generate a task to generate our college's valid registration number string
// generate calander program 

//int arr[]={10,4,5,-1,-3,Integer.MAX_VALUE,Integer.MAX_VALUE};
//int arr[]={10,4,5,-1,-3,Integer.MAX_VALUE,Integer.MAX_VALUE};
package test;
import test.MyInteger;
class rettype{
    long timems;
    int[] inputarray;
    rettype(long timems,int[] inputarray){
        this.timems=timems;
        int temp=inputarray.length;
        this.inputarray=new int[temp];
        for (int i = 0; i < inputarray.length; i++) {
            this.inputarray[i]=inputarray[i];
        }
    }
}
public class Test {
    
    int[] test;
    public int generateRandomNumber(int min, int max) {
        return (int)(System.currentTimeMillis()%(min-max+1))+min;
    }

    // public static int generateRandomPositive(int x)// main thing range and how have to generate single random no with given range
    // {
    //     long a=System.nanoTime();//My function is not bias 
    //     return (int)(a%(x+1)&0xFFFFFFFFL);   // but if we taken in time in secodes it will be bias as seconds means range from 0 to 59 so 
    // }
    
    public long a,b;
    public  int[] create_test_array(int size){
        int test_array[]=new int[size];
        // for (int i : test_array) {
        //     test_array[i]=generateRandomNumber(0,1000);
        // }
        for (int i = 0; i < size; i++) {
            test_array[i]=generateRandomNumber(40, 5000);
        }
        return test_array;
    }
    public rettype test(int[] arr) {
        int[] temp = new int[arr.length];
        a = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            temp[i] = MyInteger.bitCount(arr[i]);
        }
        b = System.nanoTime();
        rettype obj = new rettype((b - a) / arr.length, temp);
        return obj;
    }
    
    public rettype testint(int[] arr) {
        int[] temp = new int[arr.length];
        a = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            temp[i] = Integer.bitCount(arr[i]);
        }
        b = System.nanoTime();
        rettype obj = new rettype((b - a) / arr.length, temp);
        return obj;
    }
    
    public int test_accuracy(int[] output_myInteger, int[] output_Integer) {
        int count = 0;
        for (int i = 0; i < output_Integer.length; i++) {
            if (output_Integer[i] == output_myInteger[i]) {
                count++;
            }
        }
        return (count*100)/output_Integer.length;
    }

    public void test_case(int[] te){
        rettype obj1=test(te);
        rettype obj2=testint(te);
        System.out.println("Runtime of My Integer class: "+obj1.timems);
        System.out.println("Runtime of Original Integer class: "+obj2.timems);
        System.out.println("Accuracy 100% indicate our implementation gives same result as Integer class "+test_accuracy(obj1.inputarray, obj2.inputarray));
        System.out.println(obj1.inputarray[0]);
        System.out.println(obj2.inputarray[0]);
    }

    // public void buildtestcase(int No_of_iteration){
    //     System.out.println("Here we will use"+No_of_iteration+"to test the function");
        
    //     for (int i = 0; i < No_of_iteration; i++) {
    //         int x=generateRandomNumber(1, 40);
    //         test_case(x);
    //     }
    // }

     
    public static void main(String[] args) {
        
        Test obj=new Test();
        int x=obj.generateRandomNumber(1, 10);
       
        
    }
}


//as time taken in nano second it will require small range to show to output correctly less than 9999 for random range
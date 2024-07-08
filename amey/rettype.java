public class rettype{
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


    public static void main(String[] args) {
        int[] arr ={10,20,30,40};
        rettype a=new rettype(20, arr );
        System.out.println(a.timems);
        System.out.println(a.inputarray[0]);

    }
}

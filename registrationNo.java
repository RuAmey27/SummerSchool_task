

public class registrationNo {
    //student regular year/branch/000to075
    //student regulartfws year/branch/151 to 153
    //student dsy year/branch/501 to 511
    // public static int generateRandomNumber(int min, int max) {
    //     return (int)(System.currentTimeMillis()%(min-max+1))+min;
    // }
    
    public static int generateRandomNumber(int min, int max) {
        return (int)(System.nanoTime()%(min-max+1))+min;
    }
    
    public static int regulaRandom(){
        return generateRandomNumber(0, 68);
    }

    public static int tfwsrand(){
        return generateRandomNumber(150, 153);
    }

    public static int dsyrand(){
        return generateRandomNumber(500, 511);
    }
    
    public static int year(){
        return generateRandomNumber(1982, 2024);
    }

    public static String branch(){
        String[] arr={"BCS","BIT","BTT","BEC","BEL","BCH","BME","BPR","BCV","BIN"};
        return arr[generateRandomNumber(0, 10)];
    }


    public static int generateUnbaisRandom(int min, int max){ //Unbais method for random number generation
        int a=(int)(System.nanoTime()%(min-max+1))+min;
        if(a<=71&&a>=69)
        {
            return 150+(a%68);
            
        }else if(a<=71&&a>=82){
            return 500+(a%71);
        }
        else{
            return a;
        }   
    }

    //another array for selecting fun to generate no
    
    public static String choosenocodition()
    {
        int[] arr={regulaRandom(),tfwsrand(),dsyrand(),tfwsrand(),dsyrand(),regulaRandom(),dsyrand(),regulaRandom(),tfwsrand()};
        int a=generateRandomNumber(0, 9);
       
            return Integer.toString(arr[a]);
        
    }

    public static String generatRGN(String Branch,int year,String condition){
        if(condition.length()==1){
            return Integer.toString(year)+Branch+"00"+condition;
        }else if(condition.length()==2){
            return Integer.toString(year)+Branch+"0"+condition;
        }else
        {
            return Integer.toString(year)+Branch+condition;  
        }
        
        

    }//actual implementation


    public static String generatRGNIT(String condition){
        String Branch="BIT";
        int year =2024;
        if(condition.length()==1){
            return Integer.toString(year)+Branch+"00"+condition;
        }else if(condition.length()==2){
            return Integer.toString(year)+Branch+"0"+condition;
        }else
        {
            return Integer.toString(year)+Branch+condition;  
        }
        
        

    }//actual implementation


    public static Boolean length_check(String a){
       
        if (a.length()==10) {
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {


        // String a=generatRGN(branch(), year(), choosenocodition());
        // boolean test=length_check(a);
        // if (test) {
        //     System.out.println(a);
        // }else{
        //     System.out.println(a);
        // }

        // String b=generatRGNIT(choosenocodition());
        // System.out.println(b);

        for (int i = 0; i < 82; i++) {
            System.out.println(generatRGNIT(choosenocodition()));
            //TimeUnit.MINUTES.sleep(50L);
            //TimeUnit.SECONDS.sleep(100000L);

        }
        //input String of length
    }
    
}

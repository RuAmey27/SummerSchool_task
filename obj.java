class Student {
    public Integer  RegNo;
    public String Name;

    Student(int x, String a){
        this.RegNo=x;
        this.Name=a;

    }
    //static method can be invoked using objects also
    // we can also use full class name  while declaring/using class like java.lang.String
    //in toString we can display only public attribute but not private but we can use in mehtod definition

    //use of constructor is not for defining the object but to redefining the object
    //reassignment is only possible in case of final variable only while constructing the object

    //implementation of instance of 
    //integer character String and System class 
    @Override
    public java.lang.String toString() {
        // TODO Auto-generated method stub
        
        return "RegNo"+this.RegNo+"\n"+"Name"+this.Name+"\n";
        // return super.toString();
    }

    
    @Override
    public boolean equals(Object obj){
        // TODO Auto-generated method stu
        
       return super.equals(obj);
    }

    
    String Display(){
      return this.toString();
    }
    
    public static void main(String[] args) {
        Student amey=new Student(12,"amey");
        System.out.println(amey.toString());
        //amey.Display();
    }
}

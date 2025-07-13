package design_patterns;

/**
* Singleton pattern example with static factory method
*/

public class StaticFactorySingleTon{
    //initailzed during class loading
    private static final StaticFactorySingleTon INSTANCE = new StaticFactorySingleTon();
  
    //to prevent creating another instance of Singleton
    private StaticFactorySingleTon(){}

    public static StaticFactorySingleTon getSingleton(){
        return INSTANCE;
    }
}


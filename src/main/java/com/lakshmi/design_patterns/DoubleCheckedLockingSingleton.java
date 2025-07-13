package com.lakshmi.design_patterns;

/**
* Singleton pattern example with Double checked Locking
*/
public class DoubleCheckedLockingSingleton
{
     private volatile DoubleCheckedLockingSingleton INSTANCE;
  
     private DoubleCheckedLockingSingleton(){}
  
     public DoubleCheckedLockingSingleton getInstance()
     {
         if(INSTANCE == null)
         {
            synchronized(DoubleCheckedLockingSingleton.class)
            {
                //double checking Singleton instance
                if(INSTANCE == null){
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
         }
         return INSTANCE;
     }
}

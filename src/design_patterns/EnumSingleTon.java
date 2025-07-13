package design_patterns;

/**
* Singleton pattern example using Java Enumj
*/
public enum EnumSingleTon{
    INSTANCE;
}

/*This is the way we generally declare Enum Singleton , it may contain instace variable and instance method 
 * but for sake of simplicity I haven't used any, just beware that if you are using any instance method than you need to ensure thread-safety of that method if at all it affect the state of object. By default creation of Enum instance is thread safe but any other method on Enum is programmers responsibility.
 With Enum Singleton pattern you can have that in one line because creation of Enum instance is thread-safe and guranteed by JVM.

 */


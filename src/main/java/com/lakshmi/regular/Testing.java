package com.lakshmi.regular;

public class Testing {

    public static void main(String[] args) {
        /*System.out.println("Testing");

        List<String> al = new ArrayList();

        al.add("1");
        al.add("2");
        al.add("3");
        al.add("4");
        al.add("5");

        al.stream().forEach(System.out::println);

        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;

        if(b1 & b2 |  b2 & b3 | b2)

            System.out.println("Ok");
        if(b1 & b2 |  b2 & b3 | b2 | b1)
            System.out.println("dokeyOk");*/

        /*try {
            badMethod();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");*/

        /*try {
            Float f1 = new Float("3.0");
            int x = f1.intValue();
            byte b = f1.byteValue();
            double d = f1.doubleValue();
            System.out.println(x + b + d);

        } catch (NumberFormatException e) {
            System.out.println("Bad NUm");
        }*/

        /*Properties p = System.getProperties();
        p.setProperty("pirate", "scurvy");
        String s = p.getProperty("argProp") + " ";
        s += p.getProperty("pirate");*/

        try{
            badMethod();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        }finally {
            System.out.println("C");
        }
        System.out.println("D");


    }

    /*static void badMethod(int i, int arr[]) {
        arr[i] = 6;
        i = 5;
    }*/

    static void badMethod() {
        throw new RuntimeException();
    }
}



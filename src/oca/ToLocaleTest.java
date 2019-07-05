package oca;

import java.util.Locale;

public class ToLocaleTest {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("lt")); //setting Lithuanian as locale
        String str = "\u00cc";
		System.out.println("Before case conversion is "+str+" and length is "+str.length());// Ì
        String lowerCaseStr = str.toLowerCase();
		System.out.println("Lower case is "+lowerCaseStr+" and length is "+lowerCaseStr.length());// i?`
    }
}

// It performs the case conversion with respect to your Locale. When you call toLowerCase(), internally toLowerCase(Locale.getDefault()) is getting called. 
//It is locale sensitive and you should not write a logic around it interpreting locale independently.
//To make it safer, you may use another method toLowerCase(Locale.English) and override the locale to English always. But then you are not internationalized.
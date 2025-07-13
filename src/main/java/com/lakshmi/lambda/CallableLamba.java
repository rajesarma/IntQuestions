package com.lakshmi.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableLamba {

	public static void main(String args[]){
        ExecutorService es = Executors.newFixedThreadPool(2);
        getLength(es, "executor");
        getLength(es, "executor service");
        getLength(es, "Scheduled executor service");
        getLength(es, "executors");
        getLength(es, "fork join");
        getLength(es, "callable");    
        
        es.shutdown();
    }
    
    public static void getLength(ExecutorService es, final String str){
        // callable implemented as lambda expression
        Callable<String> callableObj = () -> {
            StringBuffer sb = new StringBuffer();
            return (sb.append("Length of string ").append(str).append(" is ").
                    append(str.length())).toString();
        };
        
        // submit method
        Future<String> f = es.submit(callableObj);
        
        try {
            System.out.println("" + f.get());
            
            
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }
	
}

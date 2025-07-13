package com.lakshmi.questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CountWordsFromFile {

	public static void main(String[] args) {
		File file = new File("D:\\Workspaces\\EclipseWorkSpace1\\InterviewQuestions\\src\\questions\\testFile.txt");
		
		int wordCount = 0;
		int charCount = 0;
		String s = null;
		try(Scanner sc = new Scanner(new FileInputStream(file))){
			while(sc.hasNext()) {
				s = sc.next();
				charCount += s.length();
				wordCount++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("wordCount : "+wordCount+ "; charCount: "+charCount);
		
		wordCount = 0;
		charCount = 0;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			
			while((s = br.readLine()) != null ) {
				String[] strings = s.split("\\s");
								
				wordCount += strings.length;
				
				for(String w : strings) {
					charCount += w.length();        
		        }
			}
			
			br.readLine();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("wordCount : "+wordCount+ "; charCount: "+charCount);
		
		

	}

}

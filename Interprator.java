package com.lab2.www;

import java.util.*;
import java.io.*;
import java.util.Vector;
public class Interpretor {
	
	public static void tokennizer(String array[]){
		String tokennizedArray[] = new String[array.length]; 
		for(int i = 0;i<array.length;i++){
			 StringTokenizer st = new StringTokenizer(array[i]);
			 while (st.hasMoreElements()){
				 tokennizedArray[i] = (String) st.nextElement();
		          //System.out.println(tokennizedArray[i]);    
		      }
		}
		calculation(tokennizedArray);
	}
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	} 
	
  public static void calculation(String tokennizedArray[]){
	  int values[] = new int[tokennizedArray.length];
	  String let[] = new String[tokennizedArray.length];
	  String print[] = new String[tokennizedArray.length];
	  String variable[] = new String[tokennizedArray.length];
	  for(int i=0;i<tokennizedArray.length;i++){ 
		  if(tokennizedArray[i].equals("let")){
			  let[i] = tokennizedArray[i];
		  }
		  
		  else if(tokennizedArray[i].equals("x") || tokennizedArray[i].equals("y") ){
			  
			  variable[i] = tokennizedArray[i];
		  }
		  else if(tokennizedArray[i].equals("print")){
			  print[i] = tokennizedArray[i];
			  System.out.println(tokennizedArray[i]);
		  }
		  
		  else {
			  //System.out.println(tokennizedArray[i]); 
			  values[i] = Integer.parseInt(tokennizedArray[i]);
			  //System.out.println(values[i]);
		  }
	  }
	  for(int i = 0;i<values.length;i++){
		 // System.out.println(let[i]); 
	  }
	  result(values);
  }
  
  public static void result(int value[]){
	  int add = 0;
	  for(int i = 0;i<value.length;i++){
		  add += value[i]; 
	  }
	  System.out.println("The reslut is: "+add);
	  
  }
  
  public static void readFile(){
	  Vector lineArray=new Vector();
	  String lineContents=null;
	  String commandArray[] = null; 
	  int counter=0;
	  try{
	         BufferedReader br=new BufferedReader(new FileReader("F:/workspace/Web/Lab2/src/com/lab2/www/sample.txt"));
	         while((lineContents=br.readLine())!=null){
	         lineArray.add(lineContents);
	         counter++;
	         }
	         commandArray = new String[counter];
	  }
	  catch(FileNotFoundException fne){
	  fne.printStackTrace();
	  }
	  catch(IOException io){
	  io.printStackTrace();
	  }
	  for (int i=0;i<lineArray.size();i++){
	  	commandArray[i] = (String) lineArray.get(i);
	  //System.out.println(commandArray[i]);
	  }
	  String initiallize[] = new String[commandArray.length];
	  initiallize[0] = commandArray[0];
	  initiallize[1] = commandArray[1];
	  System.out.println("***Interpreter started***");

	  	System.out.println("Initiallizing variable:\n"+initiallize[0]+": is initialized: \n"+initiallize[1]+" is initialized\n");
	  	System.out.println("*****Calculating results****");
	  	tokennizer(commandArray);
	  //System.out.println(commandArray[0]);
	   }
  
}

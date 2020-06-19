/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountingSoftware;

import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Jorda
 */
public class Income {
    static String text;
    static String newValues = "";
    static int a = 2;
    static int []sortedIncome = new int [a];
    static int []sortedDecending = new int [sortedIncome.length];
    

    public static void IncomeGetting(){
        try{
            File incomeSorted = new File("E:\\Coding\\ICS4U Culminating - Accounting Software\\src\\AccountingSoftware\\Documents\\Income_Sorted.txt");
            File incomeText = new File("E:\\Coding\\ICS4U Culminating - Accounting Software\\src\\AccountingSoftware\\Documents\\Assets.txt");
            BufferedReader reader = new BufferedReader(new FileReader(incomeSorted));
            BufferedReader reader1 = new BufferedReader(new FileReader(incomeText));
            
            String[] values = {"", "", ""};
            
            long g =  incomeText.length();
            int length = (int) g;
            int[] income = new int[length];
            a = length;
            
            for(int i = 0; i <= incomeText.length() ; i++){
                newValues = reader1.readLine();
                values[i] = newValues.substring(newValues.indexOf("$"), newValues.length());
                income[i] = Integer.parseInt(newValues.substring(newValues.indexOf("$") + 1, newValues.length()));
                sortedIncome[i] = income[i];
                
            }
            reader1.close();
        }
        catch(IOException x){
            System.out.println("Could Not Find File: " + "Income_Sorted.txt");
        }
        catch(java.lang.NullPointerException e){
            
        }
        IncomeSorting();
        PrintToText();
    }
    public static void IncomeSorting(){
        try{
       Arrays.sort(sortedIncome);
       String sortedAsending = Arrays.toString(sortedIncome);
       
       for(int i = sortedIncome.length -1; i >= 0; i--){
           File file  = new File("E:\\Coding\\ICS4U Culminating - Accounting Software\\src\\AccountingSoftware\\Documents\\Income_Sorted.txt");
           BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
           sortedDecending[i] = sortedIncome[i];
           System.out.println(sortedIncome[i]);
           writer.write("$ " + sortedIncome[i]);
           writer.newLine();
       }
     }
        catch(IOException ex){
            
        }
    }
    public static void PrintToText(){
       // try{
            
            
//            System.out.println("Writing...");
//            for(int i = 0; i <= sortedDecending.length; i++){
//                writer.newLine();
//                writer.write(sortedDecending[i]);
//                System.out.println(sortedDecending[i]);
//            }
//            writer.close();
//            System.out.println("Done!");
//        }
//        catch(IOException ex){
//            System.out.println("Could not find file");
//        }
//    }
}
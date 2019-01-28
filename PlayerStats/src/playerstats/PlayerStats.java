/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerstats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jamesostmann
 */
public class PlayerStats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       String[] playerNames = new String[80];
       int[] playerScores = new int[80];
       
       readData("playerData2.txt",playerNames,playerScores);
       printData(playerNames,playerScores);
       
        System.out.println(" ");
        
       sortNamesAndScores(playerNames,playerScores);
       printData(playerNames,playerScores); 
       
        System.out.println(" ");
        
       printTopNPlayers(3,playerNames,playerScores);
       
        System.out.println(" ");
        
       printTopNPlayers(10,playerNames,playerScores);

        
    }
    
    public static void readData(String fName, String[]names, int[]scores) {
        
        try {
            
        Scanner scan = new Scanner(new File(fName));
        int count = 0;
        
        while(scan.hasNext()){
        
            names[count] = scan.next();
            scores[count] = scan.nextInt();
            
            count++;
        
        }
        
        scan.close();
        
        
        } catch(FileNotFoundException ex){
             
          System.err.println("could not find the file for reading.");
          System.exit(-1);
        }
    
    
    }
    public static void printData(String[] names, int[] scores) {
    
        for(int i = 0; i < names.length; i++) {
        
            System.out.print(names[i] + " " + scores[i] + "\n");
            
        
        }
    
    }
    public static double averageScores(int[] scores) {
        
        double average  = 0;
        
        for(int i = 0; i < scores.length; i++) {
            
            average += scores[i];
 
        }
        
        average /= scores.length;
        
        return average;
    }
    public static void sortNamesAndScores(String[] names, int[] scores){
        
        for(int i = 0; i < names.length; i++) {
            
            int min = i;
            
           for(int j = i; j < names.length; j++) {
                
               if(scores[j] < scores[min]){
                   min = j;
               }
        
        }    
        
           int tempScore = scores[i];
           scores[i] = scores[min];
           scores[min] = tempScore;
           
           String tempName = names[i];
           names[i] = names[min];
           names[min] = tempName;
        
        
        }
        
        
    }
    public static void printTopNPlayers(int n, String[] names, int[] scores) {
       
        sortNamesAndScores(names,scores);

        for(int i = 0; i < n; i++) {
            
            System.out.print(names[i] + " " + scores[i] + "\n");
            
        }
    
    }
}

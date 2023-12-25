
package com.mycompany.lcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class LCS {
    
    static  int calculateLCS(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        
        String matching ="";
        
        int metrix[][]=new int[n+1][m+1];
        int item[][]=new int[n+1][m+1];
        
        
             for(int i=0; i<=n; i++){
                 for(int j=0; j<=m; j++){
                     if(i==0 || j==0){
                         metrix[i][j]=0;
                         item[i][j]=0;
                     }else if( s1.charAt(i-1)==s2.charAt(j-1)){
                         metrix[i][j]=1+metrix[i-1][j-1];
                         item[i][j]=1;
                         
                          //for left value is 2 and upper level value is 3 and 1 is for matching
                     }else{
                         if(metrix[i-1][j] <= metrix[i][j-1]){
                               item[i][j]=2;
                               metrix[i][j]=metrix[i][j-1];
                           }else{
                              item[i][j]=3;
                          metrix[i][j]=metrix[i-1][j];
                         }
                         
                         
                        
                     }
                     
                     
                     
                 }
             }
             
             
             int a=n,
                 b=m;
             
             while(a!=0 || b!=0){
                 if(item[a][b]==1){
                     matching=matching+(String.valueOf(s1.charAt(a-1)));
                     a=a-1;
                     b=b-1;
                 }else if(item[a][b]==2){
                     b=b-1;
                 }else{
                     a=a-1;
                 }
             }
        
        
         
          
          StringBuilder builder=new  StringBuilder(matching);
          System.out.println(builder.reverse());
        
        return metrix[n][m];
    }

    public static void main(String[] args) {
        try {
            File file=new File("C:\\Users\\User\\Desktop\\rasel\\lcs.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String firstLine = reader.readLine();
            String secondLine=reader.readLine();
            
            
           
            System.out.println(  calculateLCS(secondLine, firstLine));   
            
           
            
            
          
            
            
          
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
}

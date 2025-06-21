// q3. Find the highest/lowest frequency element
// Problem Statement: Given an array of size N. 
// Find the highest and lowest frequency element.
// Enter length of array as input:7
// Enter Array elements:
// A(0): 11
// A(1): 11
// A(2): 11
// A(3): 11
// A(4): 55
// A(5): 55
// A(6): 66
// Highest Freq. Element: 11 with Frequency: 4
// Lowest Freq. Element: 66 with Frequency: 1

import java.util.*;

public class HiLoArrOccurr {
    HiLoArrOccurr(int [] A){//EF=ELement Freq.
        HashMap<Integer,Integer> EF= new HashMap<>();
        int i;
        int L=A.length;
        for(i=0;i<L;i++){
            if(EF.containsKey(A[i])){
                //if elem already prsnt overwrt its freq by incremented freq
                EF.put(A[i],EF.get(A[i])+1);
            }else{//if elem not prsnt, add with freq=1
                EF.put(A[i],1);
            }
        }
        printHiLoHM(EF);

    }
    //2nd Attempt, corrected implementation, added explanation for revision
    public void printHiLoHM(HashMap<Integer, Integer> EF) {
        int Hi = 0;
        int Lo = EF.size();
        // Ini. keys for hi and lo freq.
        int hiKey = 0; 
        int loKey = 0;
        for (int key : EF.keySet()) {
            int F = EF.get(key);
            if (F > Hi) {
                Hi = F;
                // Update key for hi freq
                hiKey = key; 
            }
            if (F < Lo) {
                Lo = F;
                // Update key for lo freq
                loKey = key; 
            }
        }
    
        System.out.println("Highest Freq. Element: " + hiKey + " with Frequency: " + Hi);
        System.out.println("Lowest Freq. Element: " + loKey + " with Frequency: " + Lo);
    }
    

    //1st Attempt, logic correct, wrong implementation as there is no way to get Key from Element
    // without extracting entry set 
    // public void printHiLoHM(HashMap<Integer, Integer> EF){
        
    //     int Hi=0;
    //     int Lo=EF.size();
    //     for (int key : EF.keySet()) {
    //         int F=EF.get(key);
    //         if(F>Hi){
    //             Hi=F;
    //         }
    //         if(F<Lo){
    //             Lo=F;
    //         }
    //     }

    //     System.out.println("Higest Freq. Elem."+ EF.getKey(Hi)+" w/ Freq.= "+Hi);
    //     System.out.println("Lowest Freq. Elem"+ EF.getKey(Lo)+" w/ Freq. ="+Lo);
    // }

    public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter length of array as input:");
    int l=s.nextInt(); int A[]=new int[l];
    System.out.println("Enter Array elements:");
    for(int i=0;i<l;i++){
        System.out.print("A("+i+"): ");
        A[i]=s.nextInt();
    }
    HiLoArrOccurr CD= new HiLoArrOccurr(A);
    
    s.close();
}
}
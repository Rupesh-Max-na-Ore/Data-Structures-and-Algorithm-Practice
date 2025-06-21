//q2
//Print no. of occurences of elems of input array
// ex-
// Enter length of array as input:5
// Enter Array elements:
// A(0): 44
// A(1): 44
// A(2): 77
// A(3): 77
// A(4): 7
// Element: 7, No. of Occurences: 1
// Element: 44, No. of Occurences: 2
// Element: 77, No. of Occurences: 2

import java.util.*;

public class ArrayOccurr {
    ArrayOccurr(int [] A){//EF=ELement Freq.
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
        printHM(EF);

    }

    public void printHM(HashMap<Integer, Integer> EF){
        // to print HM, this time using key set
        // make a var., entry, that iterates through all keys(elem. in array) in HM(=entrySet)
        
        for (int key : EF.keySet()) {
            System.out.println("Element: " + key + ", No. of Occurences: " + EF.get(key));
        }
    }

    public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter length of array as input:");
    int l=s.nextInt(); int A[]=new int[l];
    System.out.println("Enter Array elements:");
    for(int i=0;i<l;i++){
        System.out.print("A("+i+"): ");
        A[i]=s.nextInt();
    }
    ArrayOccurr CD= new ArrayOccurr(A);
    
    s.close();
}
}

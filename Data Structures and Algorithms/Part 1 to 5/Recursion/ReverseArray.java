
//q7 Reverse Array via recursion
import java.util.Scanner;

public class ReverseArray {

    ReverseArray(int A[]){
        int l=A.length;
        int B[]=new int[l];
        System.out.println("Copy og array for reference and testing:");
        for(int i=0;i<l;i++){
        B[i]=A[i];
        }

        actuallyRevArr(A,0,(A.length-1),A.length);
        System.out.println("OG array:");
        printArr(B);
        System.out.println("Reversed array:");
        printArr(A);
        }


    private void actuallyRevArr(int A[], int i, int li, int l) {
        if(i>=li) return;
        int temp=A[i];
        A[i]=A[li];
        A[li]=temp;
        actuallyRevArr(A,(i+1),(li-1),l);
        
    }

    public void printArr(int[] a){
        System.out.print("[");
        for(int i = 0; i<a.length; i++){
            //if(a[i] != 0)
            
            if(i==a.length-1){
                System.out.print(a[i]);
            }else{
                System.out.print(a[i] + " , ");
            }
    
        }System.out.println("]");
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
    ReverseArray CD= new ReverseArray(A);
    
    s.close();
}
}



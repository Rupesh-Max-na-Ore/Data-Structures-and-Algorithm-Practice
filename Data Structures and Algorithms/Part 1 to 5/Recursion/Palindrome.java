//Q8 cHECK sTRING pALINDROME rECURSIVELY

//1ST ATTEMPT, LITTLE MISTAKE, 
//KEEPING IT TO AVOID IT IN FUTURE AS A REMINDER WHILE REVISION
// import java.util.Scanner;

// public class Palindrome {

//     Palindrome(String str)
//     {
//         String s=str;
//         int len=s.length();
//         boolean pal= Pal(s,0,len-1);
//         if(pal==true){
//             System.out.println("Palindrome");
//         }else{
//             System.out.println("Not Palindrome");
//         }
//     }

//     private boolean Pal(String str, int i, int j) {
        //MISTAKE IS HERE, FLIP LINES 22&25 HERE, REVISE WHY IT'S WRONG
//         if(str.charAt(i)!=str.charAt(j)) return false;

//         if(i>=j) return true;

//         Pal(str, i+1, j-1);
//     }

//     public static void main(String args[]){
//     Scanner s=new Scanner(System.in);
//     System.out.print("Enter string as input:");
//     String string=s.nextLine(); 
    
    
//     Palindrome CD= new Palindrome(string);
    
//     s.close();
// }
    
// }

//cORRECT aTTEMPt
import java.util.Scanner;

public class Palindrome {

    Palindrome(String str) {
        String s = str;
        int len = s.length();
        boolean pal = Pal(s, 0, len - 1);
        if (pal == true) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    private boolean Pal(String str, int i, int j) {
        //cORRECTED LINES SWAP
        if (i >= j) {
            return true;
        }
        if (str.charAt(i)!= str.charAt(j)) {
            return false;
        }
`           return Pal(str, i + 1, j - 1);
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter string as input:");
        String string = s.nextLine();
        
        Palindrome CD = new Palindrome(string);
        
        s.close();
    }
}

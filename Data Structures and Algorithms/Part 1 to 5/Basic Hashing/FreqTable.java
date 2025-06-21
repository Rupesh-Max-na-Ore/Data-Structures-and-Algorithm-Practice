
//q1
//Problem:try hashmap
/*
 * 
 * Enter a string as input: Sengoku Bushin Raijinn Ghost
Enter char you want to search as input: n
Frequency of n' = 4
 * 
 */

//2nd Attempt, Corrected 1st attempt, added explanation for future revision
import java.util.*;

public class freqTable {
    private HashMap<Character,Integer> Freq = new HashMap<>();

    public freqTable(String s){
        // Ini. freq. of all LoCase letters to 0
        for(int i = 0; i < 26; i++){
            Freq.put((char)(i + 'a'), 0);
        }
        // Count freq. of chars in s
        for(int i = 0; i < s.length(); i++){
            // store current char of s in ch
            char ch = s.charAt(i);
            //check if ch is present in HM
            if(Freq.containsKey(ch)){
                //if present, store its (int)
                //freq. of occurence in count var.
                int count = Freq.get(ch);
                //increase freq. of ch by 1
                //put it back in HM
                //this updated freq will map to same key==ch here
                Freq.put(ch, count + 1);
            }
        }
    }

    public void printHM(){
        // to print HM
        // make a var., entry, that iterates through all val of all elements in HM(=entrySet)
        for (Map.Entry<Character, Integer> entry : Freq.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        //to iterate via keyset
        // for (char key : Freq.keySet()) {
        //     System.out.println("Character: " + key + ", Frequency: " + Freq.get(key));
        // }

        // to print the HM using forEach() -- need to override forEach Method 
        //-- commonly used with lambdas/Anonymous Inner Class
        // Freq.forEach((key, value) -> System.out.println("Character: " + key + ", Frequency: " + value));
    }

    public int getFreq(char ch) {
        //if (Freq.containsKey(ch)) {
            return Freq.get(ch);
        //} 
        // Not required here as initialized all 26 alphabets to 0
        // Required in most cases
        // else {
        //     return 0; // If the character is not found, return 0
        // }
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a string as input: ");
        String input = s.nextLine();
        freqTable CD = new freqTable(input);
        System.out.print("Enter char you want to search as input: ");
        /* Pay attention, how to take char as input */
        char srch=s.next().charAt(0);;
        int srchFreq= CD.getFreq(srch);
        System.out.println("Frequency of " + srch + "' = " + srchFreq);

        //System.out.println("Printing out All Freq. of All chars.");
        //CD.printHM();
        s.close();
    }
}


//1st attempt from my memory, some minor mistakes
// import java.util.*;

// public class freqTable {
//     public HashMap<Character,Integer> Freq=new HashMap<>();
//     freqTable(String s){
//         //HashMap<Character,Integer> Freq=new HashMap<>();
//         int i;
//         for(i=0;i<26;i++){
//             Freq.put((char)(i+'a'),0);
//         }
//         for(i=0;i<s.length();i++){
//             if(Freq.containsKey(s.charAt(i))){
//                 int V = Freq.getValue(s.charAt(i));
//                 Freq.put(s.charAt(i),V+1);
//             }
//         }

//     }

//     public void printHM(HashMap<Character,Integer> H){
//         // Print the HashMap
//         for (Map.Entry<Character, Integer> entry : H.entrySet()) {
//             System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//     }}

    
// public static void main(String args[]){
//     Scanner s=new Scanner(System.in);
//     System.out.print("Enter a no. as input:");
//     int n=s.nextInt();
//     freqTable CD= new freqTable("ssmray");
//     CD.printHM(Freq);
    
//     s.close();
// }}

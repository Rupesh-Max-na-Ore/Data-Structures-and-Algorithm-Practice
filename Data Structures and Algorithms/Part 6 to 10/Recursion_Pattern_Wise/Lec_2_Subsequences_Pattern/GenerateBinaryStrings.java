package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;
/*Q1 continued: Generate and Print Binary Subseqns. with no consecutive 1s via recursion */
import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    
    // Helper method to generate and collect binary strings
    private void generateBinaryStrings(int n, String current, List<String> result) {
        if (n == 0) {
            result.add(current);
            return;
        }
        
        // Append '0' and continue recursion
        generateBinaryStrings(n - 1, current + "0", result);
        
        // Append '1' only if the previous character is not '1'
        if (current.length() == 0 || current.charAt(current.length() - 1) != '1') {
            generateBinaryStrings(n - 1, current + "1", result);
        }
    }
    
    // Parent method print all binary strings of length N w/ no consecutive 1s
    public List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generateBinaryStrings(n, "", result);
        return result;
    }
    
    public static void main(String[] args) {
        GenerateBinaryStrings solution = new GenerateBinaryStrings();
        int N = 4;
        List<String> strings = solution.generateBinaryStrings(N);
        
        for (String s : strings) {
            System.out.println(s);
        }
    }
}

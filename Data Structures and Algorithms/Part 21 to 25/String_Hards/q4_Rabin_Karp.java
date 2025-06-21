package String_Hards;

public class q4_Rabin_Karp {


    private static final int d = 26; // Base value of alphabets
  private static final int p = 5381; // Large prime number

  public static void search(String pat, String txt)
  {
    int patHash = 0; // Hash value of pattern
    int txtHash = 0; // Hash value of text

    for (int i = 0; i < pat.length(); i++) // Generating Hash values for pattern and first window text
    {
      patHash = patHash * d;
      txtHash = txtHash * d;
      patHash = patHash + ((pat.charAt(i) - 'A' + 1) % p);
      txtHash = txtHash + ((txt.charAt(i) - 'A' + 1) % p);
    }

    
    for (int i = 0; i < txt.length() - pat.length(); i++) // Loop of text size minus  window
    {
      if (patHash == txtHash)
      {
        System.out.println("Pattern found at index " + i);
      }

      if (i < txt.length() - pat.length())
      {
        txtHash = txtHash - ((txt.charAt(i) - 'A' + 1) * (int)Math.pow(d, pat.length() - 1));  // Subtracting first element from current hash of d^window-1
        txtHash = txtHash * d + (txt.charAt(i + pat.length()) - 'A' + 1);  // multiplying obtained hash with d to left shift the number and then adding the next new element
      }
    }
  }
    
  public static void main(String []args)
  {
    String txt = "GEEKS FOR GEEKS";
    String pat = "GEEK";

    search(pat, txt);
  }  
}

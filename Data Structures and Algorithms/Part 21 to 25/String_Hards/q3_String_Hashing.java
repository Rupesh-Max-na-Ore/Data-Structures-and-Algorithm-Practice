package String_Hards;

public class q3_String_Hashing {
    // static final int P = 31;           // base
    // static final int MOD = 1_000_000_009; // a large prime modulus

    // // Computes polynomial rolling hash of a string
    // public static long computeHash(String s) {
    //     long hash = 0;
    //     long power = 1;

    //     for (int i = 0; i < s.length(); i++) {
    //         int charVal = s.charAt(i) - 'a' + 1; // 'a' -> 1, 'b' -> 2, ..., 'z' -> 26
    //         hash = (hash + charVal * power) % MOD;
    //         power = (power * P) % MOD;
    //     }

    //     return hash;
    // }

    // public static void main(String[] args) {
    //     System.out.println(computeHash("abc")); // 1.31^0+2*31^1+3*31^2 = 2946
    //     System.out.println(computeHash("ejoty")); // 
    // }

    
    static final int P = 31;
    static final int MOD = 1_000_000_009;

    static long[] prefixHash;
    static long[] powers;

    // Precomputes hashes and powers
    public static void precompute(String s) {
        int n = s.length();
        prefixHash = new long[n + 1];
        powers = new long[n + 1];
        powers[0] = 1;

        for (int i = 0; i < n; i++) {
            int charVal = s.charAt(i) - 'a' + 1;
            prefixHash[i + 1] = (prefixHash[i] + charVal * powers[i]) % MOD;
            powers[i + 1] = (powers[i] * P) % MOD;
        }
    }

    // Computes hash of s[l..r] in O(1)
    public static long getHash(int l, int r) {
        long result = (prefixHash[r + 1] - prefixHash[l] + MOD) % MOD;
        result = (result * modInverse(powers[l], MOD)) % MOD;
        return result;
    }

    // Modular inverse using Fermat's Little Theorem
    public static long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    // Binary exponentiation
    public static long power(long a, long b, int mod) {
        long res = 1;
        a = a % mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        precompute(s);
        System.out.println(getHash(0, 2)); // hash of "abr"
        System.out.println(getHash(7, 9)); // hash of "abr"
        // These two should be equal => substrings are equal
    }
}



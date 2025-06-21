package String_Hards;

import java.util.HashSet;
import java.util.Set;

public class q3_RollingHash {
    static final int P = 31;               // Prime base
    static final int MOD = 1_000_000_009;  // Large prime modulus

    // Precompute powers of P
    static long[] pow;

    public static void precomputePowers(int maxLen) {
        pow = new long[maxLen + 1];
        pow[0] = 1;
        for (int i = 1; i <= maxLen; i++) {
            pow[i] = (pow[i - 1] * P) % MOD;
        }
    }

    // Compute initial hash for substring s[l..r]
    public static long computeHash(String s, int l, int r) {
        long hash = 0;
        for (int i = l; i <= r; i++) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash + val * pow[i - l]) % MOD;
        }
        return hash;
    }

    // Compute next rolling hash from previous hash
    public static long rollHash(String s, int i, int k, long prevHash) {
        int outChar = s.charAt(i - 1) - 'a' + 1;
        int inChar = s.charAt(i + k - 1) - 'a' + 1;

        // Remove the leftmost char: s[i-1]
        long hash = (prevHash - outChar + MOD) % MOD;
        hash = (hash * modInverse(P, MOD)) % MOD;

        // Add new rightmost char: s[i + k - 1]
        hash = (hash + inChar * pow[k - 1]) % MOD;

        return hash;
    }

    // Modular inverse using Fermat’s Little Theorem
    public static long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    public static long power(long a, long b, int mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    // Driver example: find all hashes of substrings of length k
    public static void main(String[] args) {
        String s = "abcdeabc";
        int k = 3;
        precomputePowers(s.length());

        Set<Long> hashes = new HashSet<>();
        long hash = computeHash(s, 0, k - 1);
        hashes.add(hash);
        System.out.println("Hash of " + s.substring(0, k) + ": " + hash);

        for (int i = 1; i <= s.length() - k; i++) {
            hash = rollHash(s, i, k, hash);
            hashes.add(hash);
            System.out.println("Hash of " + s.substring(i, i + k) + ": " + hash);
        }

        System.out.println("Unique substrings of length " + k + ": " + hashes.size());
    }
}



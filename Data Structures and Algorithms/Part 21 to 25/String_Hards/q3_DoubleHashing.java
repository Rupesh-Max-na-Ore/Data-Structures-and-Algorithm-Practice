package String_Hards;

public class q3_DoubleHashing {
    static final int P1 = 31, MOD1 = 1_000_000_007;
    static final int P2 = 53, MOD2 = 1_000_000_009;

    static long[] prefixHash1, power1;
    static long[] prefixHash2, power2;

    public static void precompute(String s) {
        int n = s.length();
        prefixHash1 = new long[n + 1];
        prefixHash2 = new long[n + 1];
        power1 = new long[n + 1];
        power2 = new long[n + 1];

        power1[0] = power2[0] = 1;

        for (int i = 0; i < n; i++) {
            int val = s.charAt(i) - 'a' + 1;

            prefixHash1[i + 1] = (prefixHash1[i] + val * power1[i]) % MOD1;
            power1[i + 1] = (power1[i] * P1) % MOD1;

            prefixHash2[i + 1] = (prefixHash2[i] + val * power2[i]) % MOD2;
            power2[i + 1] = (power2[i] * P2) % MOD2;
        }
    }

    public static long getHash1(int l, int r) {
        long hash = (prefixHash1[r + 1] - prefixHash1[l] + MOD1) % MOD1;
        return (hash * modInverse(power1[l], MOD1)) % MOD1;
    }

    public static long getHash2(int l, int r) {
        long hash = (prefixHash2[r + 1] - prefixHash2[l] + MOD2) % MOD2;
        return (hash * modInverse(power2[l], MOD2)) % MOD2;
    }

    public static boolean substringsEqual(int l1, int r1, int l2, int r2) {
        return getHash1(l1, r1) == getHash1(l2, r2) && getHash2(l1, r1) == getHash2(l2, r2);
    }

    public static long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    public static long power(long a, long b, long mod) {
        long res = 1;
        a %= mod;
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
        System.out.println(substringsEqual(0, 2, 7, 9));  // true for "abr"
        System.out.println(substringsEqual(0, 2, 1, 3));  // false for "abr" vs "bra"
    }
}



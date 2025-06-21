package Trie.Lec2_Problems;

import java.util.Arrays;

public class q7_Max_XOR_Limit_Query_Log {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums); // Sort nums for binary search
        int[] result = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int x = queries[qi][0], m = queries[qi][1];
            System.out.println("\n--- Query " + (qi + 1) + ": x = " + x + ", m = " + m);

            // Early rejection if all nums are > m
            if (nums[0] > m) {
                result[qi] = -1;
                System.out.println("All numbers are greater than m. Answer = -1");
                continue;
            }

            // Use upper_bound to get valid range: nums[i] <= m
            int end = upperBound(nums, m);
            int start = 0;
            int curPrefix = 0; // Tracks prefix we are building
            int k = 0;          // Number we build to maximize XOR

            // for (int bit = 31; bit >= 0; bit--) {
            for (int bit = 5; bit >= 0; bit--) {
                System.out.println("end = "+end+" start = "+start);
                System.out.println("k = "+k+" curPrefix = "+curPrefix);
                int bitMask = 1 << bit;
                boolean xHasBit = (x & bitMask) != 0;

                System.out.println("Bit " + bit + ": xHasBit = " + (xHasBit ? 1 : 0));

                if (xHasBit) {

                    // Prefer nums[i] with bit = 0 at this position
                    int next = lowerBound(nums, start, end, curPrefix | bitMask);
                    System.out.println("next = "+next);
                    if (start < next) {
                        k |= bitMask;
                        end = next;
                        System.out.println(" → Found 0s. Set bit " + bit + " in k → k = " + k);
                    } else {
                        curPrefix |= bitMask;
                        System.out.println(" → No 0s. Force curPrefix |= bit " + bit + " → " + curPrefix);
                    }
                } else {
                    // Prefer nums[i] with bit = 1 at this position
                    if (start < end && (nums[end - 1] & bitMask) != 0) {
                        k |= bitMask;
                        curPrefix |= bitMask;
                        start = lowerBound(nums, start, end, curPrefix);
                        System.out.println(" → Found 1s. Set bit " + bit + " in k → k = " + k);
                        System.out.println("Force curPrefix |= bit " + bit + " → " + curPrefix);
                    } else {
                        System.out.println(" → No 1s. Do nothing.");
                    }
                }
            }

            System.out.println("Max XOR = k = " + k);
            // k = x ^ candidate; so candidate = k ^ x = x ^ k = curPrefix
            System.out.println("Final best candidate = x ⊕ k = curPrefix = " + x + " ⊕ " + k + " = " + (x ^ k)); //
            System.out.println("Final best candidate = x ⊕ k = curPrefix = " + x + " ⊕ " + k + " = " + curPrefix); //
            // result[qi] = x ^ k;
            result[qi] = k;
        }

        return result;
    }

    // First index where nums[i] > target
    private int upperBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // First index where nums[i] >= target within range [start, end)
    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        q7_Max_XOR_Limit_Query_Log sol = new q7_Max_XOR_Limit_Query_Log();
        // int[] nums = {0, 1, 2, 3, 4};
        // int[][] queries = {{3, 1}, {1, 3}, {5, 6}};
        // int[] res = sol.maximizeXor(nums, queries);
        // System.out.println("\nFinal Results:");
        // System.out.println(Arrays.toString(res));

        int[] nums1 = {4, 5, 7, 8, 9};
        int[][] queries1 = {{11, 5}, {3, 5}, {4, 7}, {7, 8}, {9, 9}};
        int[] res1 = sol.maximizeXor(nums1, queries1);
        System.out.println("\nFinal Results:");
        System.out.println(Arrays.toString(res1));
    }
}


/*next = lowerBound(nums, start, end, curPrefix | bitMask)

WHy do we do this step?


ChatGPT said:
Great question.

🧩 Context of the Step
This line appears in the bit-by-bit construction of k, the number that, when XORed with x, gives a maximum value, while ensuring that it matches some number in nums ≤ m.

We are processing each bit from most significant to least (bit = 5 → 0). At each bit level, we decide:

Should we try to set this bit in k?

Is it safe to do so (i.e. does a valid nums[i] exist that aligns with this prefix)?

🔍 Meaning of the Step
java
Copy
Edit
next = lowerBound(nums, start, end, curPrefix | bitMask)
This line means:

"Find the first index in the sorted subarray nums[start:end] where the number is ≥ curPrefix | bitMask."

Here:

curPrefix is the common prefix built so far for this bit-level traversal.

bitMask = 1 << bit, so curPrefix | bitMask sets the current bit to 1.

lowerBound(...) finds the smallest index with nums[i] ≥ curPrefix | bitMask.

🤔 Why Do We Do This?
We are in the case where xHasBit == 1, so we want to prefer 0s in nums at this bit (because 1 ^ 0 = 1, which is good for XOR).

So the logic is:

We prefer numbers in nums where this bit is 0.

Such numbers will be < curPrefix | bitMask.

So we find next = lowerBound(..., curPrefix | bitMask) which gives us the split point:

All nums[i] in [start, next) will have this bit = 0.

All nums[i] in [next, end) will have this bit = 1.

Thus:

If start < next, we have some numbers with this bit = 0.
→ We can safely set this bit in k, knowing a valid number exists.

If not, then we're forced to accept 1s at this bit → must adjust curPrefix.

✅ In Summary
We do:

java
Copy
Edit
next = lowerBound(nums, start, end, curPrefix | bitMask)
to:

Partition the current search space (nums[start:end]) into two:

Ones that have this bit = 0

Ones that have this bit = 1

Efficiently determine whether it’s safe to prefer a 0 at this bit (to maximize XOR).

Ensure that the number we’re constructing actually exists in nums and is ≤ m.

Would you like this logic visualized with a concrete binary example?







You said:
Would you like this logic visualized with a concrete binary example?

Yes


ChatGPT said:
Perfect — let’s walk through this step using a binary example to show exactly why and how we do:

java
Copy
Edit
next = lowerBound(nums, start, end, curPrefix | bitMask)
🎯 Problem Setup
Let:

nums = [4, 5, 7, 8, 9]
In binary:

ini
Copy
Edit
4  =  00100
5  =  00101
7  =  00111
8  =  01000
9  =  01001
Query: x = 11, m = 5 → we restrict search to values ≤ 5 → so valid nums = [4, 5]

x = 11 = 01011

🔧 Step-by-Step Bit Processing
We loop from bit = 5 down to bit = 0. Let’s pick:

🧪 Example Bit = 2
bitMask = 1 << 2 = 0b00100 = 4

curPrefix = 0 for now

curPrefix | bitMask = 0 | 4 = 4

We do:

java
Copy
Edit
next = lowerBound(nums, start, end, 4)
Valid nums = [4, 5] (already sorted)

start = 0, end = 2

We search for the first index i where nums[i] ≥ 4

Here, nums[0] = 4, so next = 0

🚦 Now the logic splits:
We're in the xHasBit = 1 case at bit 2. So we prefer nums[i] where bit 2 = 0.

But:

All values in [0, 2) are ≥ 4, and both 4 and 5 have bit 2 = 1.

So there are no values with bit 2 = 0 in this range.

Hence, we do:

java
Copy
Edit
curPrefix |= bitMask; // Accept that we must take 1 at bit 2
🧮 Alternate Scenario
Now suppose x = 3, m = 7, and valid nums = [4, 5, 7]. Again try:

bit = 2, so bitMask = 4

curPrefix = 0

curPrefix | bitMask = 4

Do:

java
Copy
Edit
next = lowerBound(nums, 0, 3, 4)
In [4, 5, 7], first index i with nums[i] ≥ 4 is i = 0

So again next = 0

Now:

Values in [0, 0) = ∅ → no values with bit 2 = 0

So again we cannot safely set k |= 4, and must do curPrefix |= 4

✅ Final Summary
The key insight in this step is:

To maximize x ^ num, we prefer bits in num that oppose those in x.

But we can only keep num if it’s in nums and ≤ m, so we narrow down valid prefixes.

curPrefix | bitMask gives a cut-off point beyond which numbers have 1 in that bit.

By computing next = lowerBound(nums, start, end, curPrefix | bitMask):

We find the transition point from 0 to 1 at that bit.

We choose how to update k or curPrefix based on whether any 0s are left.

Would you like a diagrammatic tree (like a binary trie) to visualize this more structurally?





https://chatgpt.com/share/682b5379-1388-8005-9567-2989ab0a1f58

 */
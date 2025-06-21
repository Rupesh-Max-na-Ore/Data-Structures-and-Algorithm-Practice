package Graphs.Lec4_ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

import Graphs.Lec4_ShortestPathAlgos.q32_Dijkstra_MinHeap.iPair;

/* */
public class q33_Dijkstra_TreeSet {
    class Pair {
        int node, dist;
    
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair>> adj, int src) {
        // Write your code here
        int v = adj.size();
        int [] d = new int[v];
        Arrays.fill(d, (int)(1e9));
        d[src]=0;
        //PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.dist-y.dist);
        //TreeSet<Pair> pq = new TreeSet<>((x,y)->x.dist-y.dist);
        // TreeSet with proper comparison to handle duplicate distances
        TreeSet<Pair> pq = new TreeSet<>((x, y) -> {
            if (x.dist == y.dist) return Integer.compare(x.node, y.node);
            return Integer.compare(x.dist, y.dist);
        });        
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.pollFirst();
            for(Pair nbr: adj.get(curr.node)){
                if(d[nbr.node]>d[curr.node]+nbr.dist){
                    //if(d[nbr.node]!=1e9) pq.remove(nbr);
                    pq.remove(new Pair(nbr.node, d[nbr.node]));
                    d[nbr.node]=d[curr.node]+nbr.dist;
                    pq.add(new Pair(nbr.node, d[nbr.node]));
                }
            }
        }
        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> result = new ArrayList<>();
        for (int dist : d) {
            result.add(dist);
        }

        return result;
    }
}
//https://chatgpt.com/share/67d133e8-54dc-8005-a162-c8792725afe9
/*//gfg  User function Template for Java
class Solution {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int v = adj.size();
        int [] d = new int[v];
        Arrays.fill(d, (int)(1e9));
        d[src]=0;
        // PriorityQueue<iPair> pq = new PriorityQueue<>((x,y)->x.second-y.second);
        //TreeSet<iPair> pq = new TreeSet<>((x,y)->x.second-y.second);
        // TreeSet with proper comparison to handle duplicate distances
        TreeSet<iPair> pq = new TreeSet<>((x, y) -> {
            if (x.second == y.second) return Integer.compare(x.first, y.first);
            return Integer.compare(x.second, y.second);
        });
        pq.add(new iPair(src, 0));
        while(!pq.isEmpty()){
            iPair curr = pq.pollFirst();
            for(iPair nbr: adj.get(curr.first)){
                if(d[nbr.first]>d[curr.first]+nbr.second){
                    pq.remove(new iPair(nbr.first, d[nbr.first]));
                    d[nbr.first]=d[curr.first]+nbr.second;
                    pq.add(new iPair(nbr.first, d[nbr.first]));
                }
            }
        }
        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> result = new ArrayList<>();
        for (int dst : d) {
            result.add(dst);
        }

        return result;
    }

} */
/*Great question! The key difference between **`PriorityQueue`** and **`TreeSet`** in Java lies in **how they handle duplicate values and object identity**. Let’s dive into why this additional step is required for `TreeSet` but not for `PriorityQueue`.

---

### ✅ **1. How `PriorityQueue` Works**:
`PriorityQueue` in Java is implemented as a **binary heap**:

- **Allows duplicate elements** without issue.
- When you call `pq.add(new Pair(node, dist))`, it simply **inserts** the new element.
- **No need to remove** the old value because:
  - Old (outdated) entries sit **inside** the heap but are ignored once a newer, better path is processed.
  - Even if duplicates exist, the algorithm works correctly by always processing the smallest available value.

💡 **Why no need to remove outdated values?**
- The **heap structure** means that if an older (higher) distance is present, it remains hidden until all better (smaller) distances are processed.
- When we `poll()` the smallest element, the outdated values will **never be processed**.

---

### ✅ **2. How `TreeSet` Works**:
`TreeSet` in Java is implemented using a **Red-Black Tree** (self-balancing binary search tree):

- **Does not allow duplicate elements** (as defined by the comparator).
- When you call `pq.add(new Pair(node, dist))`, if another `Pair` with the **same `dist` value** already exists, it **won’t be added**.
- Therefore, **removing** old values is crucial before updating the distance.

💡 **Why do we need to break ties?**
- If two nodes have the **same distance**, the comparator must distinguish them—otherwise, `TreeSet` treats them as the **same object** and overwrites one.
- By using:
  
    ```java
    (x, y) -> x.dist == y.dist ? Integer.compare(x.node, y.node) : Integer.compare(x.dist, y.dist);
    ```
  
  We ensure:
  - Different nodes are treated as **distinct**, even if their distances are the same.
  - This prevents nodes from **collapsing** into one, maintaining **correct** behavior.

---

### ✅ **3. Why is this important?**
Without these additional steps, using a `TreeSet` can **break** Dijkstra’s algorithm:

1. **Incorrect removal**: If we do not remove the old value before inserting a new one, the outdated entry remains.
2. **Duplicate collapse**: Without distinguishing by the node, the `TreeSet` may treat two different nodes with the same distance as **identical** and fail to add them.

---

### ✅ **4. Example Difference in Action**:

Consider this graph:

```
    0 --(1)--> 1 --(1)--> 2
     \-------(3)-------/
```

If the source is `0`:

1. **Using `PriorityQueue`:**
   - First, we add `(1, 1)` and `(2, 3)`.
   - When processing node `1`, we update node `2` to `(2, 2)`.
   - **Old value `(2, 3)` stays**, but it will never be processed because `(2, 2)` has a lower distance.

2. **Using `TreeSet` without removal:**
   - We add `(1, 1)` and `(2, 3)`.
   - When updating node `2` to `(2, 2)`, if we do not remove `(2, 3)`, **both** values will exist.
   - This leads to incorrect behavior when extracting the minimum.

---

### ✅ **5. Summary:**

| Feature                  | `PriorityQueue`                   | `TreeSet`                     |
|--------------------------|------------------------------------|--------------------------------|
| **Duplicates**            | Allowed                            | Not allowed (as per comparator)|
| **Handling Outdated Values** | Automatically ignored by `poll()` | Must manually `remove()`       |
| **Performance**           | Faster for Dijkstra (no removal)   | Slightly slower (needs removal)|
| **Why works without removal?** | Ignores larger distances in heap | Must explicitly track and update|

👉 **In short**: We add extra steps in `TreeSet` because it doesn’t allow duplicate keys and requires manual handling of outdated values, unlike the forgiving nature of a `PriorityQueue`. */

/*The need to **create a new `Pair`** to remove from the `TreeSet` arises due to how **object identity** and **comparators** work in Java's `TreeSet`. Let’s break down the reasoning step-by-step:

---

### ✅ **1. How `TreeSet` Identifies Objects:**
- `TreeSet` does not rely on **object identity (`==`)** for equality. Instead, it uses the **comparator** you provide.
- When you call:

   ```java
   pq.remove(new Pair(vtx, d[vtx]));
   ```

   It searches for an object that is **"equal"** to the provided `Pair` **according to the comparator**.

---

### ✅ **2. Why Can’t We Use the Existing `Pair`?**
The `Pair` object you want to remove is **already inside the `TreeSet`**, but:

1. **We don’t track references to it**: 
   - Once a `Pair` is added to the `TreeSet`, you don’t hold a direct reference to it.
   - Without that reference, you cannot directly remove it.

2. **Comparator-based search**:
   - `TreeSet` performs all operations (insertion, lookup, and deletion) using the **comparator**.
   - As long as you create a new `Pair` object with the **same `node` and `dist` values**, the comparator treats it as **equivalent**, and the `remove()` method will successfully find and delete it.

---

### ✅ **3. Example to Demonstrate This Need:**
Consider the following `Pair` class:

```java
class Pair {
    int node, dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
```

And the comparator:

```java
TreeSet<Pair> pq = new TreeSet<>((x, y) -> 
    x.dist == y.dist ? Integer.compare(x.node, y.node) : Integer.compare(x.dist, y.dist));
```

If we do:

```java
pq.add(new Pair(1, 10));
pq.add(new Pair(2, 5));
```

And later want to remove the `(1, 10)` entry:

```java
pq.remove(new Pair(1, 10)); // Works because comparator checks (node == 1 && dist == 10)
```

If we didn’t create a new `Pair` with **exactly matching values**, the `remove()` call would **fail**.

---

### ✅ **4. Why Doesn’t `PriorityQueue` Need This?**
`PriorityQueue` allows **duplicate** values, and it doesn’t require explicit removal of outdated entries because:

1. **Duplicates**: Older, outdated distances stay in the heap.
2. **Lazy deletion**: It simply pulls the **smallest** value, ignoring older, larger distances.

In contrast, `TreeSet` does **not** allow duplicates, so you must explicitly **remove** the outdated entry.

---

### ✅ **5. What Happens If We Don’t Create a New `Pair`?**
If you try to remove without creating a new object:

1. The `TreeSet` will try to find the **exact object** (via comparator logic).
2. Without a new object having **matching fields**, the entry cannot be found and won’t be removed.
3. This leads to **incorrect behavior** in Dijkstra’s algorithm (processing outdated distances).

---

### ✅ **6. Summary:**
- **Why?** Because `TreeSet` only compares objects using the provided comparator.
- **What?** We must **recreate** the `Pair` object with the **same values** to properly locate and remove it.
- **PriorityQueue vs. TreeSet:** 
   - `PriorityQueue`: Automatically handles outdated entries by ignoring them.
   - `TreeSet`: Requires manual removal because it does **not** allow duplicates.

Would you like to discuss optimizations or go deeper into the mechanics? */
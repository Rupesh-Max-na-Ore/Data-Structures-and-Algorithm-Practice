package Heaps_And_PriorityQueues.Lec3_Hards;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    //Heap way
    public int[] topKFrequent(int[] nums, int k) {
        int [] ans = new int[k];
        if(nums==null||nums.length==0) return ans;
        Map<Integer,Integer> FreqMap=new HashMap<>();
        for(int num:nums) FreqMap.put(num,FreqMap.getOrDefault(num,0)+1);

        //maxHeap, Comparator:FreqMap.value 
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->FreqMap.get(b)-FreqMap.get(a));
        int i=0;
        
        for(int key:FreqMap.keySet()){
            pq.offer(key);
            if(pq.size()>FreqMap.size()-k) ans[i++]=pq.poll(); //k in ans,(n-k)in pq
        } 
        return ans;
    }
}
// // //Optimal soln using bucket sort
// public int[] topKFrequent(int[] nums, int k) {
//     List<Integer>[] bucket = new List[nums.length + 1];
//     HashMap<Integer, Integer> hm = new HashMap<>();
//     for (int num : nums) {
//         hm.put(num, hm.getOrDefault(num,0) + 1);
//     }
//     for (int key : hm.keySet()) {
//         int freq = hm.get(key);
//         if (bucket[freq] == null) {
//             bucket[freq] = new ArrayList<>();
//         }
//         bucket[freq].add(key);
//     }
//     int[] ans = new int[k];
//     int pos = 0;
//     for (int i = bucket.length - 1; i >= 0; i--) {
//         if (bucket[i] != null) {
//             for (int j = 0; j < bucket[i].size() && pos < k; j++) {
//                 ans[pos] = bucket[i].get(j);
//                 pos++;
//             }
//         }
//     }
//     return ans;
// }
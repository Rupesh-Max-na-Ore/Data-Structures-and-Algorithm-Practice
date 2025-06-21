package Arrays.Medium;
// q3
public class Majority {

    //Applying Booth's Majority ALgo
    public static int majorityElement(int[] nums) {
    int n=nums.length;
    int cnt=0; int elem=0;
    for(int num:nums){
        if(cnt==0) {
            elem=num;
            cnt++;
        }else if(num==elem) cnt++;
        else cnt--;
    }
    int f=0;
    for(int num:nums){
        if(num==elem) f++;
    }
    if(f>(n/2)) return elem;
    return -1;//never executes if there exists Majority elem
    }
        
    

    static void printArr(int nums[]){

        for(int i = 0; i< nums.length;i++){
            System.out.print( nums[i] + " " );
        }

    }

    public static void main(String[] args) {
        int arr[]= {1,1,0,0,2,1,2,1,0,0,0,0,0,0,0,0};
        System.out.print("Original array: ");
        printArr(arr);
        System.out.println();
        System.out.println("majority elem: "+Majority.majorityElement(arr));
}
}
//lc submission 1
// class Solution {
//     public int majorityElement(int[] nums) {
//     int cnt=0; int elem=0;
//     for(int num:nums){
//         if(cnt==0) {
//             elem=num;
//             cnt++;
//         }else if(num==elem) cnt++;
//         else cnt--;
    // }
    // int f=0;
    // for(int num:nums){
    //     if(num==elem) f++;
    // }
    // if(f>(nums.length/2)) return elem;
    // return -1;//never executes

    // }
//}
//lc submission 2, least space
// class Solution {
//     public int majorityElement(int[] nums) {
//     int cnt=0; int elem=0;
//     for(int num:nums){
//         if(cnt==0) {
//             elem=num;
//             cnt++;
//         }else if(num==elem) cnt++;
//         else cnt--;
//     }
//     int f=0;
//     for(int num:nums){
//         if(num==elem) f++;
//     }
//     if(f>(nums.length/2)) return elem;
//     return -1;//never executes

//     }
// }
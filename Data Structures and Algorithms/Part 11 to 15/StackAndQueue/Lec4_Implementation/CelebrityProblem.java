package StackAndQueue.Lec4_Implementation;
//Question description from YT, as locked behind LC Premium - https://www.youtube.com/watch?v=iHM1FPLGcsU
//Detailed Description available here - https://bohenan.gitbooks.io/leetcode/content/find-the-celebrity.html
// this is technically a graph problem, why is it in stack section?
// 
/*Q3 277. Find the Celebrity
Suppose you are at a party with n people (labeled from 0ton - 1) and among them, there may exist one celebrity. 
The definition of a celebrity is that all the othern - 1people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. 
The only thing you are allowed to do is to ask questions like: 
"Hi, A. Do you know B?" to get information of whether A knows B. 
You need to find out the celebrity (or verify there is not one) 
by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. 
Implement a functionint findCelebrity(n), your function should minimize the number of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. 
Return the celebrity's label if there is a celebrity in the party. 
If there is no celebrity, return-1. */
public class CelebrityProblem {
    //Celebrity - 1. knows no one 2. everyone knows 'em
    public int findCelebrity(int n) {
        // Think of 1st person as candidate, initially
        int candidate = 0;
        for(int i = 1; i < n; i++){
            // If candidate knows anyone, he is no longer the candidate cuz he knows someone
            // now the person he knows is the candidate
            if(knows(candidate, i)) candidate = i;
            // do this till find the node(person) who everyone points to, directly or indirectly
            // indirectly means there exists a path but no direct connection
        }

        //if there exists celebrity at all, then it is our final candidate till now
        //but need to check if 
        //1. this final candidate knows anyone or not
        //2. if there exists anyone who doesn't know our final candidate
        for(int i = 0; i < n; i++){
            if(i == candidate) continue; // no need to check as no one knows himself, lol
            if(knows(candidate, i) || !(knows(i, candidate))) return -1;
        }
        return candidate;
    }
    private boolean knows(int a, int b) {
        // This should return true if person a knows person b, otherwise false.
        // The actual implementation would depend on the problem's environment, like graph implemention is matrix or LL based.
        return true; // Placeholder implementation
    }
    public static void main(String[] args) {
        CelebrityProblem cp = new CelebrityProblem();
        int n = 4; // Ex. no. of people
        int celebrity = cp.findCelebrity(n);
        System.out.println(celebrity == -1 ? "No celebrity" : "Celebrity ID: " + celebrity);
    }
}

//SImilar gfg problem - link -https://www.geeksforgeeks.org/problems/the-celebrity-problem/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
// I forced use of stack here, lol, although better to do w/o it, as given below
// class Solution
// { 
//     //Function to find if there is a celebrity in the party or not.
//     int celebrity(int M[][], int n)
//     {
//     	 Stack<Integer> stack = new Stack<>();

//         // S1: Push all people onto the stack.
//         for (int i = 0; i < n; i++) {
//             stack.push(i);
//         }

//         // S2: Eliminate non-celebrities.
//         while (stack.size() > 1) {
//             int a = stack.pop();
//             int b = stack.pop();
//             if (M[a][b]==1) {
//                 stack.push(b); // a can't be a celebrity, but b might be
//             } else {
//                 stack.push(a); // b can't be a celebrity, but a might be
//             }
//         }

//         // S3: Verify the potential candidate.
//         int candidate = stack.pop();
//         for (int i = 0; i < n; i++) {
//             if (i != candidate) {
//                 //if candidate knows anyone or there exists atleast one who dpesn't know candidate  
//                 if (M[candidate][i]==1 || M[i][candidate]==0) {
//                     return -1; // then Candidate is not a celebrity
//                 }
//             }
//         }

//         return candidate;
//     }   
// }

// //w/o stack, much better soln.
// class Solution
// { 
//     //Function to find if there is a celebrity in the party or not.
//     int celebrity(int M[][], int n)
//     {
//     	int candidate =0;
    	
//     	for(int i=0;i<n;i++){
//     	    if(M[candidate][i]==1) candidate = i;
//     	}
    	
//         for (int i = 0; i < n; i++) {
//             if (i != candidate) {
//                 if (M[candidate][i]==1 || M[i][candidate]==0) return -1;
//             }
//         }

//         return candidate;
//     }
    
   
// }
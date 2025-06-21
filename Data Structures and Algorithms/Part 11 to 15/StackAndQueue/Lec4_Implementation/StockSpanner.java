package StackAndQueue.Lec4_Implementation;
/*Q2 901. Online Stock Span
Medium
Topics
Companies
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 

Constraints:

1 <= price <= 105
At most 104 calls will be made to next.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
323.5K
Submissions
490K
Acceptance Rate
66.0% */
// import java.util.ArrayList;
// import java.util.List;
import java.util.Stack;
//import java.util.Stack;
//Actually we don't need to store the array, just need spans in case of violation of --ing monotonic stack
public class StockSpanner {
    // A stack to store pairs of (price[i], span[i])
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        // While the stack is not empty and the top of the stack has a price less than or equal to the current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the span of the top of the stack to the current span
            span += stack.pop()[1];
        }
        // Push the current price and its span to the stack
        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4
        System.out.println(stockSpanner.next(85));  // return 6
    }
}

// Reference code, that stores the array
// public class OnlineStockSpan {

//     List<Integer> list;
  
//     public OnlineStockSpan() {
//       this.list = new ArrayList<>();
//     }
  
//     public int next(int price) {
//       list.add(price);
//       int count = 0;
//       for (int i = list.size() - 1; i >= 0; i--) {
//         if (list.get(i) > price)
//           break;
//         count++;
//       }
//       return count;
//     }
  
//     public int[] calculateSpans(int[] prices) {
  
//       int[] spans = new int[prices.length];
//       spans[0] = 1; // Span of first element is always 1
  
//       Stack<Integer> indexStack = new Stack<>();
  
//       // Push the index of first element
//       indexStack.push(0);
  
//       for (int i = 1; i < prices.length; i++) {
//         while (!indexStack.isEmpty()
//             && prices[indexStack.peek()] < prices[i])
//           indexStack.pop();
  
//         // If index stack is empty, the price at index 'i'
//         // is greater than all previous values
//         if (indexStack.isEmpty())
//           spans[i] = i + 1;
//         else
//           spans[i] = i - indexStack.peek();
  
//         indexStack.push(i);
//       }
  
//       return spans;
//     }
  
// }
// /**
//  * Your StockSpanner object will be instantiated and called as such:
//  * StockSpanner obj = new StockSpanner();
//  * int param_1 = obj.next(price);
//  */
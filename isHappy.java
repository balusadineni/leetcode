/**
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

*/

class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int sum_of_squares = 0;
        while (sum_of_squares != 1) {
            sum_of_squares = 0;
            while(n != 0) {
                int digit = n % 10;
                sum_of_squares += Math.pow(digit, 2);
                n = n / 10;
            } 
            
            if (sum_of_squares == 1) {
                return true;
            } else if (map.containsKey(sum_of_squares)) {
                return false;
            }
            map.put(sum_of_squares, 1);
            n = sum_of_squares;            
        }
        return true;
    }
}

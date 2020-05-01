/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum_end_here = nums[0];
        int maximum_sub_array_sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            max_sum_end_here = Math.max(nums[i], max_sum_end_here + nums[i]);
            if(maximum_sub_array_sum < max_sum_end_here) {
                maximum_sub_array_sum = max_sum_end_here;
            }
        }
        return maximum_sub_array_sum;
    }
}

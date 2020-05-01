/**
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

*/

class Solution {
    public int findMaxLength(int[] nums) {
        int nums_length = nums.length;
        int[] arr = new int[2*nums_length + 1];
        Arrays.fill(arr, -2);
        arr[nums_length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            int index = count + nums_length;
            if (arr[index] >= -1)  {
                maxlen = Math.max(maxlen, i - arr[index]);
            } else {
                arr[index] = i;
            }
        }
        return maxlen;
    }
}

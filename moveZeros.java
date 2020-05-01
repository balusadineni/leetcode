/**
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int zero_index = -1;
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && zero_index == -1) {
                zero_index = i;
            }
            if(nums[i] != 0 && zero_index != -1) {
                temp = nums[i];
                nums[i] = nums[zero_index];
                nums[zero_index] = temp;
                zero_index += 1;    
            }
        }
    }
}

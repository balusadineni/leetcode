/**
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
       int ll = nums.length;
       for(int i = 1; i < ll; i++) nums[i] = nums[i] + nums[i-1];
        
       int count=0;
    
       if(nums[0] == k) count++;
       if((ll > 1) && (nums[1] == k)) count++;
       if((ll > 1) && (nums[1] - nums[0] == k)) count++;
            
        for(int i=2;i<ll;i++) {
            if(nums[i] == k) count++;
            for(int j= i-1; j>=0; j--)
                if(nums[i] - nums[j]  == k) count++;
        }
        return count;
    }  
}

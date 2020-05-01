/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 ) return new ArrayList();
        
        HashMap<String, List> hmap = new HashMap<String, List>();
        
        for(String s : strs) {
           char[] ca = s.toCharArray();
           Arrays.sort(ca);
           String key = String.valueOf(ca);
           if(!hmap.containsKey(key)) hmap.put(key, new ArrayList());
           hmap.get(key).add(s);
        }

        return new ArrayList(hmap.values());
    }
}

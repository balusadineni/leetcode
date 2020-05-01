/**
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
*/
class Solution {
    public boolean checkValidString(String s) {
        int star = 0, left = 0, right = 0;
        
        char[] chars = s.toCharArray();
        Stack<Integer> st = new Stack<Integer>();
        
        int slen = s.length();
        
        for(int i = 0; i < slen; i++) {
            if(chars[i] == '(') st.push(i);
            if(chars[i] == ')') {
                if(!st.isEmpty()) { 
                    int j = st.pop();
                    chars[i] = '0';
                    chars[j] = '0';
                }
            }
        }
        
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '*') {
                star++;
                if(left > 0) { star--; left--; }
            }
            if(chars[i] == ')') {
                if(star > 0) star--;
                else return false;
            }
            if(chars[i] == '(') left++;
        }
        
        if(left == 0) return true;
        
        return false;
        
    }
}

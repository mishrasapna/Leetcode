/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true
*/

class Solution {
    public boolean isValid(String s) {
        
        // To store the mapping of open and its closed brackets
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
        // To track the opening and closing of brackets in order
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){            
            if(map.containsKey(c)){
            	// To store top element of stack in a temp variable
                char temp = stack.empty() ? '!' : stack.pop();
                // To check if current closing bracket is of same type
                // as the top element in stack for opening bracket
                if(temp != map.get(c)) return false;
            }
            else stack.push(c);
        }
        
        return stack.empty();
        
    }
}
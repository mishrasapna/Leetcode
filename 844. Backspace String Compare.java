/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty. 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        // To track the characters in both string with backspace '#' character
        Stack<Character> s1 = new Stack<>();
        
        // Traverse the first string and store in temp variable
        for(char c: s.toCharArray()){
            if(!s1.empty() && c == '#') s1.pop();
            else if(c != '#')s1.push(c);
        }
        
        String tempStr = s1.toString();
        // Empty the stack
        s1.clear();
        
        // Traverse the secaond string reusing stack
        for(char c: t.toCharArray()){
            if(!s1.empty() && c == '#') s1.pop();
            else if(c != '#')s1.push(c);
        }
        
        // Compare and return if both are equal
        return (s1.toString().equals(tempStr));
        
    }
}
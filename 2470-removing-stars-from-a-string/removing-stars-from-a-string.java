import java.util.*;
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder("");
        Stack<Character> cs = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='*'){
                cs.pop();
            }else{
                cs.push(s.charAt(i));
            }
        }
        while(!cs.isEmpty()){
            sb.insert(0,cs.peek());
            cs.pop();
        }
        return sb.toString();
    }
}
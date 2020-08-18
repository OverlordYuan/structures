import java.util.Stack;

/*
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */
public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        s = " "+s;
        int[] dp = new int[s.length()];
        int res = 0;
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = dp[i-2] + 2;
                }else if(s.charAt(i-1)==')'&& s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2;
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }

    public int longestValidParentheses_stack(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                if(!stack.empty()){
                    res = Math.max(res,i-stack.pop());
                }else {
                    stack.push(i);
                }
            }
        }
        return res;
    }
}

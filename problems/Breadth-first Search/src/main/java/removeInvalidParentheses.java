import java.util.ArrayList;
import java.util.List;

/*
301. 删除无效的括号
删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
说明: 输入可能包含了除 ( 和 ) 以外的字符。
示例 1:
输入: "()())()"
输出: ["()()()", "(())()"]
示例 2:
输入: "(a)())()"
输出: ["(a)()()", "(a())()"]
示例 3:
输入: ")("
输出: [""]
 */
public class removeInvalidParentheses {
    public List<String> removeInvalidParenttheses(String s){
        List<String> res = new ArrayList<String>();
        List<Character> sub = new ArrayList<Character>();
        int right = 0;
        int left = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') left++;
            if (s.charAt(i)==')') right++;
            if(left>=right) sub.add(s.charAt(i));
            else right--;
        }if(sub.size()>0){
            res.add(sub.toString());
            sub = new ArrayList<Character>();
        }
        right=0;
        left=0;
        for(int j=s.length()-1;j>=0;j--){
            if(s.charAt(j)=='(') left++;
            if (s.charAt(j)==')') right++;
            if(left<=right) sub.add(0,s.charAt(j));
            else left--;
        }
        res.add(sub.toString());
        return res;
    }
}

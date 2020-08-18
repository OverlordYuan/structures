import java.util.*;

/*
49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = new int[]{2,3,5,7,9,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,97,101};
        Map<Integer,List<String>> map = new HashMap<Integer, List<String>>();
        for(String s:strs){
            int flag = 0;
            for(int i=0;i<s.length();i++){
                flag += primes[s.charAt(i)-'a'];
            }
            if(map.containsKey(flag)){
                List<String> temp = map.get(flag);
                temp.add(s);
                map.put(flag,temp);
            }else {
                List<String> temp =new ArrayList<String>();
                temp.add(s);
                map.put(flag,temp);;
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:
    可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
    你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
来源：力扣（LeetCode）
*/
public class lengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int start = 0;
            int end = res;
            while(start < end) {
                int mid = (start + end) / 2;
                if(tails[mid] < num){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }
            tails[start] = num;
            if(res == end){
                res++;
            }
        }
        return res;
    }
//    public static int binchsearch(int[] nums,int end,int k){
//        int res = 0;
//        int mid = end/2;
//        if(nums[mid]>k){
//            res =
//        }
//
//        return res;
//    }
    public static void main(String[] args){
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}

public class Sort {

    public static void SelectionSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for (int j =i+1; j<nums.length;j++){
                if(nums[i]>nums[j]){
                    swap(nums,i,j);
                 }
            }
        }
    }

    public static void BubbleSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j+1]<nums[j]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    public static void InsertionSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int insertitem = nums[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(nums[j]>insertitem){
                    nums[j+1] = nums[j];
                }else {
                    break;
                }
            }
            nums[j+1] = insertitem;
        }
    }
    public static void QuickSort(int[] nums,int start,int end){
        if(nums.length>0 && start<end){
            int mid = start;
            int left = start;
            int right = end;
            int flag = nums[mid];
            while(left<right){
                while(nums[right]>=flag&&left<right){
                   right--;
                }
                nums[mid] = nums[right];
                mid = right;
                while(nums[left]<=flag&&left<right){
                    left++;
                }
                nums[mid] = nums[left];
                mid = left;
            }
            nums[mid] = flag;
            QuickSort(nums,start,mid);
            QuickSort(nums,mid+1,end);
        }
    }

    public static void swap(int[] nums, int i ,int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String args[]){
        int[] nums =new int[]{2,0,2,1,1,0};
//        InsertionSort(nums);
        QuickSort(nums,0,nums.length-1);
        for (int i:
             nums) {
            System.out.println(i);
        }

    }
}


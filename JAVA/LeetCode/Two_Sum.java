package JAVA.LeetCode;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            for(int j=i+1; j<nums.length; j++){
                int b = nums[j];
                if (a + b == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}

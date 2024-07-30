import java.util.HashMap;

public class Solution {
    // ways to solve:
    // 1. iterate (brute-force) - worst
    // 2. HashMap - best

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> remainders = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];

            if (remainders.containsKey(diff)) {
                return new int[] {remainders.get(diff), i};
            } 
            else {
                remainders.put(nums[i], i);
            }
        }

        return new int[] {};
    }

    public static void main(String args[]) {
        // int[] nums = {3,4,5,6}; 
        int[] nums = {4,5,6}; 
        int target = 10;

        int[] res = twoSum(nums, target);
        for (int i : res) {
            System.out.println(i);
        }
    }
}

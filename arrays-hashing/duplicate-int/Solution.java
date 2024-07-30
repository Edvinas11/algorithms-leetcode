import java.util.HashSet;
import java.util.Set;

public class Solution {
    // ways to solve:
    // 1. iterate (brute-force) - worst
    // 2. sort - worst in memory
    // 3. HashSet - best

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();

        for (int num : nums) {
            if (uniques.contains(num)) {
                return true;
            }
            else {
                uniques.add(num);
            }
        }

        return false;
    }

    public static void main(String args[]) {
        int[] nums = { 1, 2, 3};

        if (hasDuplicate(nums)) {
            System.out.println("has duplicates");
        }
        else {
            System.out.println("no duplicates");
        }
    }
}

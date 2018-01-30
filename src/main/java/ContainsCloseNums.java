import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer k, determine whether there are two
distinct indices i and j in the array where nums[i] = nums[j] and the absolute
difference between i and j is less than or equal to k.

Example

For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be
containsCloseNums(nums, k) = true.

There are two 2s in nums, and the absolute difference between their positions is exactly 3.

For nums = [0, 1, 2, 3, 5, 2] and k = 2, the output should be

containsCloseNums(nums, k) = false.

The absolute difference between the positions of the two 2s is 3, which is more than k.

Input/Output

[time limit] 3000ms (java)
[input] array.integer nums

Guaranteed constraints:
0 ≤ nums.length ≤ 55000,
-231 - 1 ≤ nums[i] ≤ 231 - 1.

[input] integer k

Guaranteed constraints:
0 ≤ k ≤ 35000.

[output] boolean

 */
public class ContainsCloseNums {
    public static void main(String[] args) {

    }

    boolean containsCloseNums(int[] nums, int k) {

        if (nums == null || nums.length == 0){
            return false;
        }


        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean match = false;

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                if ((i - value) <= k){
                    match = true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return match;

    }
}

package easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author lhl
 * @date 2019-12-23
 */
public class 两数之和_哈希 {

    private static int[] nums={2, 11, 15, 7};
    private static int target = 9;

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dataIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            dataIndexMap.put(num, i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int left = target - num;
            if(dataIndexMap.containsKey(left) && dataIndexMap.get(left) != i) {
                return new int[]{i, dataIndexMap.get(left)};
            }
        }
        throw new IllegalArgumentException("No tow sum solution");
    }

    public static void main(String[] args) {
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}

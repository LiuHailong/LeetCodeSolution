package solution.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯
public class 全排列 {

    public List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return result;
        LinkedList<Integer> track = new LinkedList<>();
        return permuteHelper(nums, track);
    }

    private List<List<Integer>> permuteHelper(int[] nums, LinkedList<Integer> track) {
        // 定义返回条件, 遍历到叶子节点时, track.size == nums.length
        if(nums.length == track.size()) {
            // track是个引用的关系, 所以这里要new一个对象出来
            result.add(new LinkedList<>(track));
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(track.contains(num)) continue;
            track.addLast(num);
            permuteHelper(nums, track);
            track.removeLast();
        }

        return result;
    }

    public static void main(String[] args) {
        全排列 o = new 全排列();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = o.permute(nums);
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }
}

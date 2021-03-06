package solution.easy;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//
//
// 注意：
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//输入：x = -123
//输出：-321
//
// 示例 3：
//输入：x = 120
//输出：21

// 示例 4：
//输入：x = 0
//输出：0

// 示例 5：
//输入：x = 120010
//输出：21

// 提示：
// -231 <= x <= 231 - 1
public class 整数反转 {
    public static int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int mod = x % 10;
            x = x / 10;

            // Integer.MAX_VALUE => 2147483648
            // 如果 ret > Integer.MAX_VALUE / 10 (214748364) 那么 * 10后必然溢出
            // 如果 ret = Integer.MAX_VALUE / 10 (214748364) 但是余数 > 7 , 那么 * 10 也会溢出
            if(ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && mod > 7)) return 0;
            // 负数同理
            if(ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && mod < -8)) return 0;

            ret = ret * 10 + mod;
        }
        return ret;
    }
    // 1534236469
    // 2147483648

    public static void main(String[] args) {
//        System.out.println(reverse(0));
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
//        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
}

package easy;

/**
 * 分式化简
 * <p>
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 * <p>
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * <p>
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * <p>
 * 限制:
 * <p>
 * cont[i] >= 0
 * 1 <= cont的长度 <= 10
 * cont最后一个元素不等于0
 * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 * <p>
 * https://leetcode-cn.com/problems/deep-dark-fraction/
 *
 * @author lhl
 * @date 2019-12-24
 */
public class DeepDarkFraction {

    private static int[] cont = {1, 5, 6, 6, 5, 7, 5, 5, 4, 7};

    public static int[] fraction(int[] cont) {
        int deo = cont[cont.length - 1];
        int num = 1;
        int temp;

        for (int i = cont.length - 1; i >= 1; i--) {
            temp = num;
            num = deo;
            deo = num * cont[i - 1] + temp;
        }

        return new int[]{deo, num};
    }

    public static void main(String[] args) {
        int[] fraction = fraction(cont);
        for (int i = 0; i < fraction.length; i++) {
            int i1 = fraction[i];
            System.out.println(i1);
        }
    }
}

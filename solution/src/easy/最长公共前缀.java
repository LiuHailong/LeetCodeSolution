package easy;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
public class 最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (flag) {
            String str = strs[0];
            if (str.equals("")) break;
            char prefixChar = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str2 = strs[j];
                if(i >= str2.length()) {
                    flag = false;
                    break;
                }
                char curChar = str2.charAt(i);
                if (prefixChar != curChar) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(prefixChar);
            }
            if (i < str.length() - 1) {
                i++;
            }else {
                break;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] strs = new String[]{"flower", "flow", "flight"};
//        String[] strs = new String[]{"dog","racecar","car"};
//        String[] strs = new String[]{"dog"};
        String[] strs = new String[]{"ab","a"};
        System.out.println(longestCommonPrefix(strs));
    }
}

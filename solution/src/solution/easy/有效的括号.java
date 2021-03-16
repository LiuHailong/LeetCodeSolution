package solution.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
public class 有效的括号 {
    public static boolean isValid(String s) {
        if(s == null || s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('[', ']');
                put('(', ')');
                put('{', '}');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                Character topChar =  stack.peek();
                if(map.get(topChar) != c) {
                    return false;
                }
                stack.pop();
            }

        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("){"));
//        System.out.println(isValid("(([]){})"));
//        System.out.println(isValid("(}{)"));
//        System.out.println(isValid("(){}}{"));
//        System.out.println(isValid("){"));
//        System.out.println(isValid("()[]{}"));
//        System.out.println(isValid("{[]}"));
    }
}

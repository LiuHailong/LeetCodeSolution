package solution.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
public class N皇后 {
    public List<List<String>> data = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return data;
        // 记录点位
        List<StringBuilder> board = initBoard(n);
        solveNQueensHelper(board, 0);
        return data;
    }


    private void solveNQueensHelper(List<StringBuilder> board, int row) {
        // 定义结束条件
        if (row == board.size()) {
            List<String> track = new ArrayList<>();
            for (int i = 0; i < board.size(); i++) {
                track.add(board.get(i).toString());
            }
            data.add(track);
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除可以互相攻击的位置
            if (canAttack(board, row, col)) continue;

            board.get(row).setCharAt(col, 'Q');

            solveNQueensHelper(board, row + 1);
            board.get(row).setCharAt(col, '.');
        }
    }

    /* 判断能否再row col的位置放置皇后 */
    private boolean canAttack(List<StringBuilder> board, int row, int col) {
        int n = board.size();
        // 判断当前列是否可以放置
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') return true;
        }

        // 判断右上是否可以放置
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return true;
        }


        // 判断左上是否可以放置
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return true;
        }

        return false;
    }

    /* 初始化棋盘 */
    private List<StringBuilder> initBoard(int num) {
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num; j++) {
                sb.append(".");
            }
            board.add(sb);
        }
        return board;
    }

    public static void main(String[] args) {
        N皇后 o = new N皇后();
        List<List<String>> res = o.solveNQueens(5);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.println(s);
            }
            System.out.println();
        }

    }
}

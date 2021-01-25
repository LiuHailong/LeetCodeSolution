package easy;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表


//leetcode submit region begin(Prohibit modification and deletion)
public class 合并两个有序链表 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode mergedList = new ListNode();

        mergeTwoLists(mergedList, l1, l2);

        return mergedList.next;
    }

    private static void mergeTwoLists(ListNode mergedList, ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return;
        int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
        int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;

        if (v1 > v2) {
            mergedList.next = new ListNode(v2);
            l2 = l2.next;
        } else {
            mergedList.next = new ListNode(v1);
            l1 = l1.next;
        }
        mergeTwoLists(mergedList.next, l1, l2);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        while(listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
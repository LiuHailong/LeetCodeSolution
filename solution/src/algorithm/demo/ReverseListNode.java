package algorithm.demo;

import algorithm.struct.ListNode;

/**
 * 翻转单链表
 */
public class ReverseListNode {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        println(a);

        ListNode reverseListNode = reverse(a);
        println(reverseListNode);
    }

    private static void println(ListNode reverseListNode) {
        if(null == reverseListNode) {
            System.out.println();
            return;
        }
        System.out.print(reverseListNode.val);
        println(reverseListNode.next);
    }

    private static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

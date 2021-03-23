package algorithm.demo;

import algorithm.struct.ListNode;

/**
 * 翻转单链表的一部分
 */
public class ReversePartListNode {

    private static ListNode successor = null;

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

        int m = 2;
        int n = 4;

        ListNode reverseListNode = reverseBetween(a, m ,n);
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

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private static ListNode reverseN(ListNode head, int n) {
        if(n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}

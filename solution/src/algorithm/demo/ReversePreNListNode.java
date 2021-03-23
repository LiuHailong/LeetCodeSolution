package algorithm.demo;

import algorithm.struct.ListNode;

/**
 * 翻转单链表前N个节点
 */
public class ReversePreNListNode {

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

        ListNode reverseListNode = reverse(a, 3);
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

    private static ListNode reverse(ListNode head, Integer n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}

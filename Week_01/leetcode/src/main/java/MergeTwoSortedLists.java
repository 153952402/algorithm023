
public class MergeTwoSortedLists {
    /**
     * 合并两个有序链表
     * 审题
     *      1. 待合并链表有序且均为升序
     *      2. 返回合并后的链表首元素
     * 边界条件
     *      1. 两个链表中某一个链表为空
     *      2. 两个链表均为空
     *      3. 链表l1最小节点值 大于 链表l2所有节点值 或反之
     *      4. 链表l1，l2 所有节点值相同
     *
     *  可用解法
     *      1. 归并排序
     *      2.
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2.next = l2;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l1 : l2;
        return head.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

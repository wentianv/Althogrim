package com.zt.althogrim.array;


import com.zt.althogrim.array.ListNode;

/**
 * @Auther: ASUS
 * @Date: 2019/7/26 22:02
 * @Description:链表中环的入口结点
 *
 * 一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * 环的入口结点是结点3。
 */
public class EntryNodeInListLoop {


    public static void main(String[] args) {

    }

    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);

        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }return slow;
    }
}

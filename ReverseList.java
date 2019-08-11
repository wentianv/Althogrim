package com.zt.althogrim.array;

/**
 * @Auther: ASUS
 * @Date: 2019/7/23 21:09
 * @Description:  链表反转
 *
 *  1 > 2 > 3 > 4 > 5
 *
 *  5 > 4 > 3 > 2 > 1
 */


public class ReverseList {


    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        ListNode node = reverse(list1);
        int b = 1;
    }
    // 1 > 2 > 3 > 4 > 5
    static ListNode reverse(ListNode head){
        ListNode first = new ListNode(-1);
        ListNode pNode = head;
        while(pNode!=null){
            ListNode pNext = pNode.next;// 先将 pNode 下一个节点标记

            pNode.next = first.next;
            first.next = pNode;
            pNode = pNext;
        }
        return first.next;
    }
}

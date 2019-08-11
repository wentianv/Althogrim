package com.zt.althogrim.array;

/**
 * @Auther: ASUS
 * @Date: 2019/7/23 22:36
 * @Description:
 *
 *  删除 ListNode 中指定元素节点
 */
public class RemoveEleNode {

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

        removeElement(list1,1);
    }


    static ListNode removeElement(ListNode head,int val){
        while(head!=null && head.val == val){
            head = head.next;
        }
        if(head == null) return null;

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }
}

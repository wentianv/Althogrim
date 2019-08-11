package com.zt.althogrim.array;

/**
 * @Auther: ASUS
 * @Date: 2019/7/23 10:29
 * @Description:
 *
 * 删除排序链表中重复的节点
 */
public class DeleteDuplicationInList {

    // 1 -> 2 -> 2 -> 3 -> 3 -> 4
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3_1 = new ListNode(3);
        ListNode node3_2 = new ListNode(3);
        ListNode node4_1 = new ListNode(4);
        ListNode node4_2 = new ListNode(4);
        ListNode node4_3 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3_1;
        node3_1.next = node3_2;
        node3_2.next = node4_1;
        node4_1.next = node4_2;
        node4_2.next = node4_3;
        node4_3.next = node5;

        deleteDuplicateNode(node1);
    }

    // 递归方法
    static ListNode deleteDuplicateNode(ListNode head){
       if(head == null || head.next == null) return head;
       ListNode next = head.next;
       if(head.val == next.val){
           while(next!=null && head.val==next.val){
               next = next.next;
           }
           return deleteDuplicateNode(next);
       }else{
           head.next = deleteDuplicateNode(next);
           return head;
       }
    }

    // 1 ->2 -> 3 -> 3 -> 4 -> 4 -> 4  -> 5
    static ListNode deleteDuplication(ListNode pHead){
        if(pHead==null) return null;
        // 辅助头节点,头结点有可能重复被删除
        ListNode first = new ListNode(-1);
        first.next = pHead;
        // 移动指向当前节点的节点
        ListNode p = pHead;
        // 前节点
        ListNode preNode = first;
        while(p!= null && p.next!=null){
            if(p.val == p.next.val){ // 两 节点相等
                int val = p.val; // 将【重复值】 提取出来 用于判断前后节点是否还会继续重复
                while(p!=null && p.val == val){  // 用于跳过相等的节点,用于删除
                    p = p.next;
                }
                preNode.next = p;
            }else {
                preNode = p;
                p = p.next;
            }
        }
        return first.next;
    }
}

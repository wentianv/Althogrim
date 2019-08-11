package com.zt.althogrim.array;

/**
 * @Auther: ASUS
 * @Date: 2019/7/23 17:52
 * @Description:
 * 合并两个排序列表
 *  1 -> 3 -> 5
 *  2 -> 4 -> 6
 */
public class MergeTwoList {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n3;
        n3.next = n5;
        n2.next = n4;
        n4.next = n6;
        ListNode node = merge2(n1,n2);
        ListNode node1 = merge1(n1,n2);
    }

    /**
     *  递归方法
     * @param list1
     * @param list2
     * @return
     */
    static ListNode merge1(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val <= list2.val){
            list1.next = merge1(list1.next,list2);
            return list1;
        }else{
            list2.next = merge1(list1,list2.next);
            return list2;
        }
    }

    /**
     *  非递归方法
     *  1 -> 3 -> 5
     *  2 -> 4 -> 6
     * @param list1
     * @param list2
     * @return
     */
    static ListNode merge2(ListNode list1,ListNode list2){
        ListNode first = new ListNode(-1);
        ListNode cur = first;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 != null){
            cur.next = list1;
        }

        if(list2!=null){
            cur.next = list2;
        }
        return first.next;
    }
}
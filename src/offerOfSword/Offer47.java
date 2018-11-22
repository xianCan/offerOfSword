package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/11/22 13:53
 *
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 核心思路：
 *     1.先给原链表添加一个头结点方便处理；
 *     2.使用3个指针，一个指向前一个节点last，一个指向当前节点p，一个指向下一个节点p->next。
 *     3.当当前节点跟后一个节点相等时，不断往后遍历，找到第一个不等于当前节点的节点；然后用
 *     last 指向它；当当前节点跟后一个不相等时，将last 后移指向p，p后移一位
 */
public class Offer47 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null || pHead.next==null)return pHead;
        ListNode first = new ListNode(-1);
        ListNode last = first;
        first.next = pHead;
        while(pHead != null && pHead.next != null){
            if(pHead.val == pHead.next.val){
                int val = pHead.val;
                while (pHead!=null && pHead.val == val)pHead = pHead.next;
                last.next=pHead;
            }
            else {
                last = pHead;
                pHead = pHead.next;
            }
        }
        return first.next;
    }
}

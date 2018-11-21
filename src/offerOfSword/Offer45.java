package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/11/21 10:14
 *
 * 题目描述：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路：双指针判断是否存在环，如果存在的话此时快慢指针指向同一个节点，我们可以让一个指针从起点开始走，让一个指针从相遇点开始继续往后走，
 * 2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x），从相遇点开始走的那个指针也一定刚好到达环入口点。所以2者会相
 * 遇，且恰好相遇在环的入口点。
 *
 */
public class Offer45 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //非空判断
        if(pHead==null|| pHead.next==null|| pHead.next.next==null)return null;
        //初始化
        ListNode p1=pHead.next;
        ListNode p2=pHead.next.next;
        //跳出循环条件：p1==p2 或者 快指针p2为空 或者 快指针p2.next 为空
        while(p1 != p2 && p2!= null && p2.next != null){
            //p1移动一位
            p1 = p1.next;
            //p2移动两位
            p2 = p2.next.next;
        }
        //跳出循环后，如果p1==p2，证明存在环
        if(p1==p2) {
            p1 = pHead;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

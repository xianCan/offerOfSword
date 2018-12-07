package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/12/7 16:01
 *
 * 复杂链表：每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点
 */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    public RandomListNode(int label){
        this.label=label;
    }
}

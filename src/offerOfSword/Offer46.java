package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/11/22 10:07
 *
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅
 * 包含左右子结点，同时包含指向父结点的指针。
 */
public class Offer46 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null) return null;
        //如果有右子树，则找右子树的最左节点
        if(pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //没有右子树，则找第一个当前节点是父节点左孩子的节点
        while(pNode.next!=null){
            if(pNode.next.left==pNode) return pNode.next;
            pNode=pNode.next;
        }
        //退到了根节点仍没找到，则返回null
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;
    TreeLinkNode(int val) {
        this.val = val;
    }
}
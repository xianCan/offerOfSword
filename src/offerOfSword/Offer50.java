package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/11/26 16:58
 *
 * 题目描述：
 *     输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调
 * 整树中结点指针的指向。
 *
 * 中序遍历
 */
public class Offer50 {
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree){
        if(pRootOfTree == null) return;
        ConvertSub(pRootOfTree.left);
        if(head == null){
            head = pRootOfTree;
            realHead = pRootOfTree;
        }else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}

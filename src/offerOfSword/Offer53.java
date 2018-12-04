package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/11/30 17:32
 *
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class Offer53 {
    int index=0;//计数器
    TreeNode result=null;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null)
            findKthNode(pRoot,k);
        return result;
    }

    /**
     * 中序遍历寻找第k个数
     * @param pRoot
     * @param k
     */
    private void findKthNode(TreeNode pRoot, int k){
        if (pRoot == null) return;
        findKthNode(pRoot.left,k);
        index++;
        if (index == k)
            result = pRoot;
        findKthNode(pRoot.right,k);
    }
}

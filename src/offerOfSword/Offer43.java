package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/11/20 9:26
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 优化：后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
 */
public class Offer43 {
    /**
     * 判断一棵树是否为平衡二叉树
     * @param root 根节点
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    /**
     * 获得树的深度
     * @param root
     * @return
     */
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        //递归求左子树高度
        int left = getDepth(root.left);
        //如果左子树高度出现-1，直接返回
        if (left == -1) return -1;
        //递归求右子树高度
        int right = getDepth(root.right);
        //如果右子树高度出现-1，直接返回
        if (right == -1) return -1;
        //如果左右子树高度差超过1，直接返回-1，停止遍历
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}





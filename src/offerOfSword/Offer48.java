package offerOfSword;

import java.util.Stack;

/**
 * @authod xianCan
 * @date 2018/11/23 9:30
 *
 * 题目描述：
 *     请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Offer48 {
    /**
     * 非递归算法
     * @param pRoot 根节点
     * @return
     *
     * 使用stack来保存成对的节点
     * 1.出栈的时候也是成对成对的 ，
     *     1.若都为空，继续；
     *     2.一个为空，返回false;
     *     3.不为空，比较当前值，值不等，返回false；
     * 2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.rigth,right.left
     */
    public boolean isSymmetrical(TreeNode pRoot){
        //非空判断
        if(pRoot == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        //成对插入
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()){
            //成对取出，注意取出的顺序
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            //两个都为空的情况，中断当次循环
            if (left == null && right == null) continue;
            //同样为空的情况上一步已经判断过了，只有一个为空，返回true
            if (left == null || right == null) return false;
            if (left.value != right.value) return  false;
            //成对插入，同样需要注意插入的顺序
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    /**
     * 递归算法
     * @param pRoot 根节点
     * @return
     *
     * 1.只要pRoot.left和pRoot.right是否对称即可
     * 2.左右节点的值相等且对称子树left.left， right.right ;left.rigth,right.left也对称
     */
    public boolean isSymmetricalRecursive(TreeNode pRoot){
        if (pRoot==null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    /**
     * 私有递归方法
     * @param left 左节点
     * @param right 右节点
     * @return
     */
    private boolean isSymmetrical(TreeNode left, TreeNode right){
        if (left == null && right == null)return true;
        if (left == null || right == null)return false;
        return left.value == right.value
                && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }
}

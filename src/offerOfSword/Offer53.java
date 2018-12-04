package offerOfSword;

import java.util.ArrayList;

/**
 * @authod xianCan
 * @date 2018/11/30 17:32
 *
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class Offer53 {
    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        findNode(pRoot);
        if (k>0 && k<=list.size()){
            return list.get(k-1);
        }
        else return null;
    }
    private void findNode(TreeNode pRoot){
        if (pRoot==null) return;
        findNode(pRoot.left);
        list.add(pRoot);
        findNode(pRoot.right);
    }
}

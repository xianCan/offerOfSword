package offerOfSword;

import java.util.ArrayList;

/**
 * @authod xianCan
 * @date 2018/11/30 16:46
 *
 * 题目描述：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 方法：绑定深度
 */
public class Offer52 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        printTreeNode(pRoot,1);
        return result;
    }

    private void printTreeNode(TreeNode pRoot,int depth){
        if (pRoot==null) return;
        if (depth > result.size())
            result.add(new ArrayList<Integer>());
        result.get(depth-1).add(pRoot.value);
        printTreeNode(pRoot.left,depth+1);
        printTreeNode(pRoot.right, depth+1);
    }
}

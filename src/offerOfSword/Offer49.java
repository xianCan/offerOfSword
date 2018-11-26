package offerOfSword;

import java.util.ArrayList;

/**
 * @authod xianCan
 * @date 2018/11/26 9:05
 *
 * 题目描述：
 *     输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根
 * 结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Offer49 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null) return res;
        findPath(root, target);
        return res;
    }

    public void findPath(TreeNode root, int target){
        path.add(root.value);
        //已经到达叶子节点，并且正好加除了target
        if (root.value == target && root.left ==null && root.right == null){
            //将该路径加入res结果集中
            res.add(new ArrayList(path));
        }
        //如果左子树非空，递归左子树
        if (root.left != null){
            findPath(root.left, target-root.value);
        }
        //如果右子树非空，递归右子树
        if (root.right != null){
            findPath(root.right, target - root.value);
        }
        //无论当前路径是否加出了target，必须去掉最后一个，然后返回父节点，去查找另一条路径，最终的path肯定为null
        path.remove(path.size()-1);
        return;
    }
}

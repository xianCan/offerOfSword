package offerOfSword;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @authod xianCan
 * @date 2018/12/7 17:41
 *
 * 题目描述：
 *     请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Offer60 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int depth=1;
        //s1存放奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);//根节点位于奇数层
        //s2存放偶数层节点
        Stack<TreeNode> s2 = new Stack<>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (!s1.empty() || !s2.empty()){
            if (depth%2 ==1){
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.empty()){
                    TreeNode node = s1.pop();
                    if (node != null){
                        temp.add(node.value);
                        //把左右节点存进偶数栈
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()){
                    result.add(temp);
                    depth++;
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.empty()){
                    TreeNode node = s2.pop();
                    if (node != null){
                        temp.add(node.value);
                        //把右左子节点存进奇数栈，注意左右子节点存的顺序
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()){
                    result.add(temp);
                    depth++;
                }
            }
        }
        return result;
    }
}

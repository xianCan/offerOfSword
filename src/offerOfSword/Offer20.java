package offerOfSword;

import java.util.Stack;

/**
 * @author xianCan
 * @date 2018/11/17 13:23
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 模拟该过程
 */
public class Offer20 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //创建一个栈存储压入顺序
        Stack<Integer> stack = new Stack<>();
        //标记弹出序列的第m个元素
        int m=0;
        for(int i=0;i<pushA.length;i++){
            //把数据压入栈
            stack.push(pushA[i]);
            //如果栈的顶部元素和弹出序列的第一个元素相等，开始弹出，并且m自增
            while(!stack.isEmpty() && stack.peek()==popA[m]){
                stack.pop();
                m++;
            }
        }
        return stack.isEmpty();
    }
}

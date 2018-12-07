package offerOfSword;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @authod xianCan
 * @date 2018/12/4 17:12
 *
 * 题目描述：
 *     给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个
 * 滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 思路：用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 *     1.判断当前最大值是否过期
 *     2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 */
public class Offer55 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size==0) return result;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i=0;i < num.length; i++){
            if (queue.isEmpty())
                queue.add(i);
            //如果当前保存的最大值的下标小于滑动窗口的左下标，把最大值从队头弹出
            else if (queue.peekFirst() < i-size+1)
                queue.pollFirst();
            //把队列中比当前下标的值小的都丢掉
            while ((!queue.isEmpty()) && num[queue.peekLast()] <= num[i])
                queue.pollLast();
            queue.add(i);
            if (i-size+1>=0)
                result.add(num[queue.peekFirst()]);
        }
        return result;
    }
}

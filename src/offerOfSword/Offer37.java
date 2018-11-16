package offerOfSword;

import java.util.LinkedList;

/**
 * Created by xianCan on 2018/11/15 14:23
 *
 * 约瑟夫环
 */
public class Offer37 {
    /**
     *  下标从0开始
     * @param n 总人数
     * @param m 数到第几个出列
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<n; i++){
            list.add(i);
        }
        int bt = 0;
        while(list.size()>1){
            //第一次删掉的位置是从1开始数m个位置，以后每次从删掉的下一个节点开始取，
            // 所以每次要在bt的索引处加上m，因为是环，所以加了以后对链表长度取余
            bt = (bt+m-1) % list.size();
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : 0;
    }
    //测试
    public static void main(String[] args){
        System.out.println(LastRemaining_Solution(10,5));
    }
}

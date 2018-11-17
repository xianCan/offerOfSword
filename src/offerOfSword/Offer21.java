package offerOfSword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xianCan
 * @date 2018/11/17 12:25
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Offer21 {
    public int MoreThanHalfNum_Solution(int [] array) {
        //利用map来存储对应的值，每出现一次，value加一
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            Integer temp = map.get(array[i]);
            //如果取出来的值是空的，证明还没有存进map，进行初始化
            if(temp==null){
                map.put(array[i], 1);
                temp = 1;
            }else{
                map.put(array[i],++temp);
            }
            if(temp>array.length/2)return array[i];
        }

        return 0;
    }
}

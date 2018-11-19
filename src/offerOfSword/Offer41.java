package offerOfSword;

import java.util.HashMap;
import java.util.Map;

/**
 * @authod xianCan
 * @date 2018/11/19 16:20
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 *
 */
public class Offer41 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        //非空判断
        if(numbers==null || length<=0 || numbers.length!=length)return false;
        Map<Integer,Integer> map = new HashMap<>();
        //遍历数组
        for(int i=0;i<numbers.length;i++){
            //从map中取出来
            Integer integer = map.get(numbers[i]);
            //如果为空，则代表第一次存进去
            if(integer==null)map.put(numbers[i],1);
            //如果出现一次，则直接返回
            else if(integer==1) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{3,1,6,0,2,5,3};
        int [] duplication = new int[1];
        Offer41 o = new Offer41();
        boolean b = o.duplicate(numbers, numbers.length, duplication);
        System.out.println(b);
        System.out.println(duplication[0]);
    }
}

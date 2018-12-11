package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/12/11 15:49
 *
 * 题目描述：
 *     我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 *
 * 思路：竖着摆就是跳一个，横着摆就是挑两个，这样分析的话，以后就不用每次都从头分析，只要把问题能转换为青蛙跳，就能归并为斐波那契数列问题。
 */
public class Offer61 {
    /**
     * 递归版本
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target<=0){
            return 0;
        }else if(target==1 || target==2){
            return target;
        }else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }

    /**
     * 迭代版本
     * @param target
     * @return
     */
    public int RectCover2(int target){
        if(target<1) return 0;
        int g=1,f=2;
        while (--target>0){
            f = f+g;
            g = f-g;
        }
        return g;
    }
}

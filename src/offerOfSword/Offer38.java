package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/11/16 9:38
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C)
 *
 * 解法：用位运算自定义乘法：类似快速幂，俗称快速模乘。
 *     a * b 可以这样算：
 *     res = 0
 *     while(a){
 *         if(a & 1) res += b;
 *         a >>= 1;
 *         b <<= 1;
 *     }
 * 原理是把a拆成2的幂的和，a = 2^e0 + 2^e1 + 2^e2....
 * 那么 a * b = (2^e0 + 2^e1 + 2^e2+...) * b = b * 2^e0 + b * 2^e1 + b * 2^e2 + ...
 * = (b << e0) + (b << e1) + ....
 */
public class Offer38 {
    public int Sum_Solution(int n) {
        return multi(n,n+1)>>1;
    }

    /**
     * 用位运算自定义乘法
     * @param a 乘数
     * @param b 被乘数
     * @return
     */
    public int multi(int a,int b){
        int result=0;
        boolean flag1 = ((a&1)==1) && ((result += b)>0);
        a>>=1;b<<=1;
        boolean flag2 = (a>0) && ((result += multi(a,b))>0);
        return result;
    }

    public static void main(String[] args){
        Offer38 o= new Offer38();
        System.out.println(o.Sum_Solution(5));
    }
}

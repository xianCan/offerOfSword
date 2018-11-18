package offerOfSword;

/**
 * @author xianCan
 * @date 2018/11/18 10:29
 *
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Offer40 {
    public int StrToInt(String str) {
        //非空判断
        if(str.length()==0 || "".equals(str.trim()))
            return 0;
        //转化为字符数组
        char[] chars = str.trim().toCharArray();
        //标志位：symbol判断是否出现+-；i如果字符数组首位出现+-，则遍历从下标1开始
        int symbol = 0,i=0;
        if(chars[0]=='-'){
            symbol=-1;
            i=1;
        }else if(chars[0]=='+'){
            symbol=1;
            i=1;
        }
        //把sum定义为long类型，方便后来判断溢出
        long sum=0;
        //遍历字符数组
        for(;i<chars.length;i++){
            //如果出现非0-9的字符，直接返回0
            if(chars[i]<48 || chars[i]>57)
                return 0;
            sum = sum*10 + chars[i] - 48;
        }
        //如果小于整型的最小值，返回0
        if(symbol==-1 && sum*symbol<Integer.MIN_VALUE){
            return 0;
        }
        //如果大于整型最大值，返回0
        else if(sum>Integer.MAX_VALUE){
            return 0;
        }
        return symbol==-1?(int)sum*-1:(int)sum;
    }
}

package offerOfSword;
/**
 * Created by xianCan on 2018/11/14 12:33
 *
 * 循环左移：对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Offer34 {
    public String LeftRotateString(String str,int n) {
        if(n >= str.length()){
            return str;
        }
        String s1 = str.substring(0, n);
        String s2 = str.substring(n,str.length());
        return s2+s1;
    }
}

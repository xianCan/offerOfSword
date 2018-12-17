package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/12/11 16:30
 *
 * 题目描述：
 *     请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Offer62 {
    public boolean isNumeric(char[] str) {
        //标记符号、小数点、e是否出现过
        boolean sign=false,decimal=false,hasE=false;
        for (int i=0;i<str.length;i++){
            if (str[i] == 'e' || str[i] == 'E'){
                if (i == str.length-1) return false;//e如果位于最后一位，直接返回false
                if (hasE) return false;//不能同时存在两个e
                hasE=true;
            }else if (str[i] == '+' || str[i] =='-'){
                //第二次出现+-符号，必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i>0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
                sign = true;
            }else if (str[i] == '.'){
                //e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) return false;
                decimal=true;
            }else if (str[i]<'0' || str[i]>'9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[] chars = new char[]{'1','+','2','3'};
        Offer62 o = new Offer62();
        boolean numeric = o.isNumeric(chars);
        System.out.println(numeric);
    }

}

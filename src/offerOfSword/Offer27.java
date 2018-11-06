package offerOfSword;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Offer27 {
    public int FirstNotRepeatingChar(String str){
        //将字符串转换为字符数组
        char[] chars = str.toCharArray();
        //创建一个长度合适的数组来存放字母出现的次数,
        /**
         * 1.可以数组长度减去65来减少空间复杂度
         * 2.可以创建长度为256的数组来辨识全部ASCII码值
         */
        int[] a = new int['z'+1-65];
        for (char b: chars) {
            a[(int)b-65]++;
        }
        for(int i=0;i<chars.length;i++){
            if(a[chars[i]-65] == 1){
                return i;
            }
        }
        return -1;
    }
}

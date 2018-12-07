package offerOfSword;

import java.util.*;

/**
 * @authod xianCan
 * @date 2018/12/7 13:48
 *
 * 题目描述：
 *     请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Offer58 {
    //用map来存储字符出现的次数
    Map<Character,Integer> map = new HashMap<>();
    //用list来存储字符出现的次序
    List<Character> list = new ArrayList<>();
    public void Insert(char ch) {
        if(map.get(ch)==null)
            map.put(ch,1);
        else map.put(ch,map.get(ch)+1);
        list.add(ch);
    }
    public char FirstAppearingOnce() {
        for (int i=0;i<list.size();i++){
            if (map.get(list.get(i))==1)
                return list.get(i);
        }
        return '#';
    }
}

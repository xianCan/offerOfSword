package offerOfSword;

import java.util.Stack;

/**
 *Created by xianCan on 2018/11/14 13:03
 *
 * “student. a am I”。翻转为“I am a student.”
 */
public class Offer35 {
    public String ReverseSentence(String str) {
        if("".equals(str.trim()) || str.length() == 0){
            return str;
        }
        Stack<String> reverse = new Stack<>();
        String string = str.trim();
        String[] strings = str.split(" ");
        for (int i=0;i<strings.length;i++){
            reverse.push(strings[i]);
        }
        string = reverse.pop();
        while(!reverse.isEmpty()){
            string = string + " " + reverse.pop();
        }
        return string;
    }
}

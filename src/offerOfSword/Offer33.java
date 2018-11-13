package offerOfSword;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S。
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Offer33 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(array == null || array.length==0){
            return arrayList;
        }
        int left=0,right=array.length-1,total;
        while(left<right){
            total = array[left] + array[right];
            if(total == sum){
                arrayList.add(array[left]);
                arrayList.add(array[right]);
            } else if(total >sum){
                right--;
            } else {
                left++;
            }
        }
        return arrayList;
    }
}

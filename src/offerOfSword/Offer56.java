package offerOfSword;

import java.util.LinkedList;

/**
 * @authod xianCan
 * @date 2018/12/6 14:14
 *
 * 题目描述：
 *     如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 */
public class Offer56 {
    LinkedList<Integer> list = new LinkedList<>();
    public void Insert(Integer num) {
        if (list.size()==0){
            list.add(num);
            return;
        }
        //二分法插入
        int left=0,right=list.size()-1,mid=0;
        while (left<=right){
            mid=(left+right)>>1;
            if (num<list.get(mid))right=mid-1;
            else left=mid+1;
        }
        list.add(left,num);
        return;
    }

    public Double GetMedian() {
        int len = list.size();
        if (len%2==1)
            return new Double(list.get(len>>1));
        else {
            return new Double((list.get(len/2-1)+list.get(len/2))/2.0);
        }
    }
}

package offerOfSword;

/**
 *统计一个数字在排序数组中出现的次数。
 *
 * 核心思想：
 * 方法一：二分法找到一个k，然后向前向后遍历
 * 方法二：二分法找到第一个k,二分法找到最后一个k，然后相减+1
 */
public class Offer28 {
    public int GetNumberOfK(int [] array , int k) {
        int count=0;

        int index = getResult(array, k, 0, array.length - 1);
        if(index != -1){
            count++;
        }
        for (int i=index+1;i<array.length;i++){
            if(array[i] == k){
                count++;
            }else if(array[i] != k){
                break;
            }
        }
        for(int i=index-1;i>=0;i--){
            if(array[i] == k){
                count++;
            }else if(array[i] != k){
                break;
            }
        }
        return count;
    }
    private int getResult(int[] array, int k, int start, int end){
        int mid = (start+end)/2;
        while (start <= end){
            if(k>array[mid]){
                start=mid+1;
            }else if(k<array[mid]){
                end  =mid-1;
            }else{
                return mid;
            }
            mid = (start+end)/2;
        }
        return -1;
    }
}

package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/12/4 15:19
 *
 * 题目描述：
 *     在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Offer54 {
    int result=0;
    public int InversePairs(int [] array) {
        if (array != null && array.length>0)
            mergeSort(array,0,array.length-1);
        return result;
    }

    /**
     * 归并排序（从上到下）
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     */
    private void mergeSort(int[] arr,int left,int right){
        if (left>=right)return;
        int mid = (left+right)>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    /**
     * 将一个数组中的两个相邻有序区间合并成一个
     * @param arr 数组
     * @param left 左边界
     * @param mid 中间分界节点
     * @param right 右边界
     */
    private void merge(int[] arr,int left,int mid,int right){
        int[] tempArr = new int[right-left+1];
        int k = 0,i = left,j = mid+1;
        while (i<=mid && j<=right){
            if (arr[i]<=arr[j]){
                tempArr[k++] = arr[i++];
            } else {
                result = (result+mid-i+1)%1000000007; //core code
                tempArr[k++] = arr[j++];
            }
        }
        while (i<=mid){
            tempArr[k++] = arr[i++];
        }
        while (j<=right){
            tempArr[k++] = arr[j++];
        }
        for (k=0;k<tempArr.length;k++){
            arr[k+left] = tempArr[k];
        }
    }
}

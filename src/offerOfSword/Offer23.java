package offerOfSword;

/**
 *连续子向量的最大和（包括负数）
 */
public class Offer23 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0 || array == null){
            return 0;
        }else {
            int total = array[0], maxSum = array[0];
            for (int i = 1; i < array.length; i++) {
                if (total > 0) {
                    total += array[i];
                } else {
                    total = array[i];
                }
                if (total > maxSum) {
                    maxSum = total;
                }
            }
            return maxSum;
        }
    }
}

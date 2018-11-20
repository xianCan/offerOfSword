package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/11/20 15:17
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Offer44 {
    /**
     * 判断数组是否是后序遍历的结果
     * @param sequence 要判断的结果
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length==0)return false;
        return isBST(sequence,0,sequence.length-1);
    }

    /**
     * 判断是否是后序遍历子方法
     * @param sequence 要判断的数组
     * @param start 起始位置
     * @param end 终止位置
     * @return
     */
    private boolean isBST(int[] sequence, int start, int end){
        //递归出口，起始位置和终止位置在同一位置时，证明数组长度只有1，返回true
        if(start>=end)return true;
        //当前数组最后一个元素就是根节点
        int root = sequence[end];
        //声明分割节点
        int splitIndex;
        //第一个比根节点大的位置就是分割节点
        for(splitIndex=start;splitIndex<end && sequence[splitIndex]<root;splitIndex++);
        //从分割节点往后遍历数组，应该每一个元素都比根节点大
        for(int i=splitIndex;i<end;i++){
            //如果存在比根节点小，证明不是后序遍历，直接返回false
            if(sequence[i]<root){
                return false;
            }
        }
        //两个分割好的数组继续递归，直到分割到最小
        return isBST(sequence,start,splitIndex-1) && isBST(sequence,splitIndex,end-1);
    }
}


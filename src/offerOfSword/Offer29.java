package offerOfSword;

/**
 *一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 *
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 *
 * 核心思想：当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
 *
 *     依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。
 * 我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
 * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
 * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
 * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
 */
public class Offer29 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if(length ==2){
            num1[0] = array[0];
            num2[0] = array[0];
        }
        int bitResult = 0;
        for(int i=0;i<length;i++){
            bitResult ^=array[i];
        }
        int index = findFirst1(bitResult);
        for (int i = 0;i<length;i++){
            if(isBit1(array[i],index)){
                num1[0] ^=array[i];
            }else{
                num2[0] ^=array[i];
            }
        }
    }
    //找到第一个位数为1需要右移的位数
    private int findFirst1(int bitResult){
        int index = 0;
        while(index<32 && ((bitResult & 1)==0)){
            bitResult = bitResult >>1;
            index++;
        }
        return index;
    }
    //数组分组：判断该位是否为1
    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}

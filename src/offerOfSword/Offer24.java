package offerOfSword;


/**
 * 从1 到 n 中1出现的次数
 */
public class Offer24 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<0)
            return 0;
        int count = 0;
        //不完整阶梯段的1的个数
        long numberOfOne;
        for(long i=1;i<=n;i*=10){
            long diviver = i*10;
            //不完整阶梯段的数字，比如317，k为17；比如29，k为9
            long k = n%diviver;
            if(k>i*2-1) numberOfOne=i;
            else if(k<i) numberOfOne=0;
            else numberOfOne=k-i+1;
            count+=(n/diviver)*i + numberOfOne;
        }
        return count;
    }

    /*
    * 暴力解法

     public int NumberOf1Between1AndN_Solution(int n) {
            int count=0;
            StringBuffer s=new StringBuffer();
            for(int i=1;i<n+1;i++){
                 s.append(i);
            }
            String str=s.toString();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='1')
                    count++;
            }
            return count;
      }
     */
}

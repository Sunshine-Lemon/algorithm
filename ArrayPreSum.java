package algorithm;

//前缀和数组算法：用于计算一个索引区间内的数组元素之和
public class ArrayPreSum {
    private int[] preSum;

    //构造方法:通过输入的数组来构造一个前缀和数组
    public ArrayPreSum(int[] array){
        preSum = new int[array.length + 1];
        /* preSum[0] = 0,便于后面累加得到preSum[i]
         * preSum[i]的数值大小就等于array[0]~array[i - 1]的元素和
         * 每一个preSum[i]特点都是从array[0]开始累加
         */
        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i - 1] + array[i - 1];
        }
    }

    //求array闭区间[left, right]的元素和
    public int sumRange(int left, int right){
        int sum = preSum[right + 1] - preSum[left];
        return sum;
    }
}

/* 普通方法：根据边界范围，用for循环遍历求和
public class PreSum {
    private int[] array;

    public PreSum(int[] array){
        this.array = array;
    }

    public int sumRange(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += array[i];
        }
        return res;
    }
}
*/
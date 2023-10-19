package algorithm;

//差分数组算法：用于频繁对原始数组的某个区间元素进行增减操作
public class Difference {
    private int[] diffArray;

    //构造方法
    public Difference(int[] array){
        assert array.length > 0;
        diffArray = new int[array.length];
        //根据初始数组构造差分数组：diff[i] = array[i] - array[i - 1]
        diffArray[0] = array[0];
        for(int i = 1; i < array.length; i++){
            diffArray[i] = array[i] - array[i - 1];
        }
    }

    //对数组给定区间[i,j]的元素进行增加val的操作（val可以为负）
    public void increment(int left, int right, int val){
        //先暂时将[left,...]的所有元素增加val
        diffArray[left] += val;
        //再将[right + 1,...]的元素减少val，还原成原来的数值
        if((right + 1) < diffArray.length){
            diffArray[right + 1] -= val;
        }
        //综合起来就实现了将[left,right]的元素增加val的效果
    }

    //根据差分数组反推改变之后的数组
    public int[] getChangedArray(){
        int[] result = new int[diffArray.length];
        result[0] = diffArray[0];
        for(int i = 1; i < diffArray.length; i++){
            result[i] = diffArray[i] + result[i - 1];
        }
        return result;
    }
}

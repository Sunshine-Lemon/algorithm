package algorithm;

public class BinarySearch {
    // 二分查找基础版
    public static int binarySearchBasic(int[] array, int target){
        //这里的start与end都表示需要参与比较的元素，左闭右闭区间
        int start = 0, end = array.length - 1;
        int middleIndex;
        while(start <= end){
            middleIndex = (start + end) >>> 1;
            if(target < array[middleIndex]){
                end = middleIndex - 1;
            }
            else if(array[middleIndex] < target){
                start = middleIndex + 1;
            }
            else {
                return middleIndex;
            }
        }
        return -1;//没有找到返回-1
    }
    /* Tips:
        1. while循环里面的判断条件要写成 <= ,避免当start与end相等时遗漏比较
        2. 在计算中间坐标时，最好使用无符号右移 >>> 运算，避免数据溢出得到负数，
           不能简单地使用 /2 或者有符号右移 >> 运算
        3. 在进行大小比较时，符号的选择最好适应数组的排序方式
    */

    // 二分查找改动版
    public static int binarySearchAlternative(int[] array, int target){
        //这里只有start表示的元素需要参与比较，而end只表示一个边界，一定不是参与
        //参与比较的元素，左闭右开区间
        int start = 0, end  = array.length;
        int middleIndex;
        while(start < end){
            middleIndex = (start + end) >>> 1;
            if(target < array[middleIndex]) {
                end = middleIndex;
            }
            else if(array[middleIndex] < target){
                start = middleIndex + 1;
            }
            else {
                return middleIndex;
            }
        } 
        return -1;
    }
}

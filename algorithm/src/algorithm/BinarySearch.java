package algorithm;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearchBasic(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -(i + 1);//java的返回值，如果找不到目标数就返回插入点。
        //其实i所对应的索引就是插入点，为了区分0索引才使用i+1来确定插入点。
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 14, 17, 28, 29};
        int target = 2;
        int i = binarySearchBasic(arr,target);
        System.out.println(i);

        if (i < 0) {
            int insertIndex = Math.abs(i + 1);//i<0说明没有目标函数，通过返回值的绝对值找到插入点索引。
            int[] b = new int[arr.length + 1];
            System.arraycopy(arr,0,b,0,insertIndex);
            b[insertIndex] = target;
            System.arraycopy(arr,insertIndex,b,insertIndex+1, arr.length-insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }
}

package algorithm;

import sun.security.mscapi.CPublicKey;

public class Fibonacci {
    /*public static void main(String[] args) {
        //计算斐波那契数的第12个数字是几
        int[] arr = new int[12];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[11]);
    }*/


    //利用递归方法求斐波那契数
    public static void main(String[] args) {
        System.out.println(getSum(5));
    }

    public static int getSum(int a) {
        if (a == 1 || a == 2) {
            return 1;
        }
        return getSum(a - 1) + getSum(a - 2);
    }
    /*这个递归我一开始一直没理解，用Debug调试了多次之后才明白了运行的原理
    关键在于最后的return这两个式子相加在程序内部是分开计算运行的，假设我们输入的参数是大于2的，
    如果a-1的值返回为false的时候就会一直计算a-1的值，直到a-1返回为true,才会跳到后面的a-2进行计算
    最终的结果相当于是好多个1相加起来的和，这样就说明用递归的方法得到的值n越大，计算机的计算量就越大*/
}

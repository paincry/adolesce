package algorithm;

public class Fibonacci {
    public static void main(String[] args) {
        //计算斐波那契数的第12个数字是几
        int[] arr= new int[12];
        arr[0]=1;
        arr[1]=1;
        for (int i = 2; i < arr.length; i++) {
            arr[i]= arr[i-1]+arr[i-2];
        }
        System.out.println(arr[11]);
    }
}

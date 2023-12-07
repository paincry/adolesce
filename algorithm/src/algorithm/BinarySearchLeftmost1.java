package algorithm;

public class BinarySearchLeftmost1 {
    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (a[mid] < target) {
                i = mid + 1;
            } else if (target < a[mid]) {
                j = mid - 1;
            } else {
                candidate = mid;
                j = mid -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7,8,17,17,17,33,42};
        int target = 17;
        int i =binarySearchLeftmost1(a,target);
        System.out.println(i);
    }

}

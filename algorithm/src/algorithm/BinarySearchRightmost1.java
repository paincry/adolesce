package algorithm;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class BinarySearchRightmost1 {
    public static int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (a[mid] < target) {
                i = mid + 1;
            } else if (a[mid] > target) {
                j = mid - 1;
            }else{
                candidate= mid;
                i = mid+1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] a= {1,2,3,3,3,3,3,4};
        int target = 3;
        int i = binarySearchRightmost1(a,target);
        System.out.println(i);
    }
}

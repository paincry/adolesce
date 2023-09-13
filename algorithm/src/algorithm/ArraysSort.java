package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {
    public static void main(String[] args) {
        //定义数组并存储一些员工对象，利用Arrays中的sort方法进行排序
        //属性要有姓名，年龄，身高。
        //按照年龄的大小进行排序，如果年龄一样就按照升高来排序，身高一样按照姓名字母来排序，姓名暂时不涉及中文

        //提示，下列代码需要自己创建一个User类来使用
        /*User u1 = new User("xiaozhang", 18, 1.75);
        User u2 = new User("xiaohong", 20, 1.88);
        User u3 = new User("xiaolv", 19, 1.66);
        User u4 = new User("zhangsan", 19, 1.66);

        User[] arr = {u1, u2, u3, u4};
        //利用Arrays中的sort进行排列
        Arrays.sort(arr, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                //比较年龄的大小
                double temp = o1.getAge() - o2.getAge();
                //比较身高的大小
                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                //比较年龄的大小
                temp = temp==0?o1.getName().compareTo(o2.getName()):temp;
                if(temp>0){
                    return 1;
                }else if (temp<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        //展示一下数组中的内容
        System.out.println(Arrays.toString(arr));*/
    }
}


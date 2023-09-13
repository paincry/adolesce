package algorithm;

public class Recursion {
    //递归的算法练习
    //猴子吃桃子，每天吃一半多吃一个，到第十天还没吃就剩一个桃子，第一天有多少个桃子
    /*public static void main(String[] args) {
        System.out.println(getCount(1));
    }

    public static int getCount(int day) {
        if (day <= 0 || day > 10) {
            System.out.println("输入错误");
            return -1;
        }
        if (day == 10) {
            return 1;
        }
        //关键是这里，我们要先知道后一天的数量，所以是day+1，然后再用后一天的数量+1，再乘2
        return (getCount(day + 1) + 1) * 2;
    }*/







    //小明爬楼梯，可以一次爬一阶也可以一次爬两阶，如果有20层楼梯，小明有几种爬法
    /*public static void main(String[] args) {
        System.out.println(getCount(20));
    }

    public static int getCount(int a){
        //如果只有一个台阶，就只有一种爬法
        if (a==1){
            return 1;
        }
        //如果只有两个台阶，就只有两种爬法
        if (a==2){
            return 2;
        }
        //这里需要理解一个问题，就是从第19-20阶楼梯只有一种爬法，从第18-20阶楼梯我们也只算一次上去这一种爬法
        //因为18-20分两次爬上去这种方法，18爬到19我们在0-19的时候已经计算过一次了
        //口述很难形容，建议画图理解
        //最终的结论就是20阶的爬法其实就是18和19阶爬法的和
        return getCount(a-1)+getCount(a-2);
    }*/





    //上一道题的改进，如果小明还有可能一次爬3阶，那么20阶楼梯有多少种爬法
    public static void main(String[] args) {
        System.out.println(getCount(20));
    }
    public static int getCount(int a){
        if (a==1){
            return 1;
        }
        if (a==2){
            return 2;
        }
        if (a==3){
            return 4;
        }
        return getCount(a-1)+getCount(a-2)+getCount(a-3);
    }

}

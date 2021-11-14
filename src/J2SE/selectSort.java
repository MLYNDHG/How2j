package J2SE;

public class selectSort {
    public static void main(String[] args) {
        int a[]=new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i]=(int)(Math.random()*100);
        }
        //选择排序:
            //选择法排序的思路
            //把第一位和其他所有的进行比较，只要比第一位小的，就换到第一个位置来
            //比较完后，第一位就是最小的
            //然后再从第二位和剩余的其他所有进行比较，只要比第二位小，就换到第二个位置来
            //比较完后，第二位就是第二小的
        //从大到小排序
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[j]<a[i]){
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            //System.out.println(a[i]);
        }
        //冒泡排序
            //冒泡法排序的思路：
            //第一步：从第一位开始，把相邻两位进行比较
            //如果发现前面的比后面的大，就把大的数据交换在后面，循环比较完毕后，最后一位就是最大的
            //第二步： 再来一次，只不过不用比较最后一位
        //从大到小排序
        int b[]=new int[10];
        for (int i = 0; i < b.length; i++) {
            b[i]=(int)(Math.random()*100);
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length-i-1; j++) {
                if(b[j]<b[j+1]){
                    temp = b[j];
                    b[j] = b[j+1];
                    b[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
//总结  选择排序就是前面的与后面的一一比较相交换
//        冒泡排序就是两两比较 将大的向后推
    }
}

package J2SE;
//Array类的使用
//copyOfRange	数组复制
//toString()	转换为字符串
//sort	排序
//binarySearch	搜索
//equals	判断是否相同
//fill	填充
import java.util.Arrays;
public class ArraysTest {
    public static void main(String[] args) {
        int a[]=new int[10];
        for (int i = 0; i < 10; i++) {
            a[i]=(int)(Math.random()*100);
        }
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println("");
        int b[]=Arrays.copyOfRange(a,0,3);
        for (int i : b) {
            System.out.print(i+" ");
        }
        String content=Arrays.toString(b);
        System.out.println(content);


        System.out.println("排序前");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("排序后");
        System.out.println(Arrays.toString(a));

        System.out.println("90的位置:"+ Arrays.binarySearch(a,90));

        int c[]=new int[10];
        Arrays.fill(c,10);
        System.out.println(Arrays.toString(c));
    }
}

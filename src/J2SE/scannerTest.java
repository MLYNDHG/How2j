package J2SE;
import java.util.Scanner;
public class scannerTest {
    public static void main(String[] args) {
        //读取整数
        Scanner sc=new Scanner(System.in);
        int num;
        num=sc.nextInt();
        //读取浮点数
        float fnum;
        fnum=sc.nextFloat();
        //读取字符串
        sc.nextLine();//此处读取上一个输入的回车  屏蔽
        String str=sc.nextLine();
        System.out.println(num);
        System.out.println(fnum);
        System.out.println(str);
    }
}

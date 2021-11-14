package J2SE;
//增强型循环
public class forEach {
    public static void main(String[] args) {
        int a[]=new int[10];
        for (int i = 0; i < 10; i++) {
            a[i]=(int)(Math.random()*100);
        }
        for (int each : a) {
            System.out.println(each);
        }
    }
}

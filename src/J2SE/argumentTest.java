package J2SE;
//数组
//定义：int []a   int a[]都可以
public class argumentTest {
    public static void main(String[] args) {
        //Math.random() 会得到一个0-1之间的随机浮点数
        int a[]=new int[5];//未赋值
        //int a[]=new int[]{1,2,3,4,5};声明并赋值
        //int[] b = {100,102,444,836,3236};与上一行作用一致
        for (int i=0;i<5;i++){
            a[i]=(int)(Math.random()*100);
        }
        //输出最小值
        int min=100;
        for (int i=0;i<5;i++){
            if(a[i]<min){
                min=a[i];
            }
            System.out.println(a[i]);
        }
        System.out.println("最小值："+min);
    }
}

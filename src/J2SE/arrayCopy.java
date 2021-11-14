package J2SE;
//System.arraycopy()赋值数组
public class arrayCopy {
    public static void main(String[] args) {
        int a[]=new int[10];
        for (int i = 0; i < 10; i++) {
            a[i]=(int)(Math.random()*100);
        }
        int b[]=new int[10];
        //System.arraycopy(src, srcPos, dest, destPos, length)
            //src: 源数组
            //srcPos: 从源数组复制数据的起始位置
            //dest: 目标数组
            //destPos: 复制到目标数组的起始位置
            //length: 复制的长度
        System.arraycopy(a,0,b,0,10);
        for (int i : b) {
            System.out.print(i+" ");
        }
        System.out.println("");
        //利用System.arraycopy()合并数组
        int c[]=new int[20];
        System.arraycopy(a,0,c,0,10);
        System.arraycopy(b,0,c,10,10);
        for (int i : c) {
            System.out.print(i+" ");
        }
    }
}

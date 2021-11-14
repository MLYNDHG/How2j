package J2SE;
//准确的来说就是被final修饰的变量 只有一次赋值的机会
public class finalTest {
    public static void main(String[] args) {

    }
    public void method(final int j){
        final int i=0;
        //i=10;报错
        //j=10;也会报错
    }
}

package J2SE.ZOO;

public class Spider extends Animal{
    protected Spider(){
        super(8);//
    }
    @Override
    public void eat() {
        System.out.println("蜘蛛吃虫子");
    }
}

package J2SE.ZOO;

public class Fish extends Animal implements Pet{
    String name;
    public Fish(){
        super(0);
    }
    @Override
    public void walk() {
        System.out.println("🐟没有脚不能走路");
    }

    @Override
    public void eat() {
        System.out.println("鱼翅");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void play() {
        System.out.println("吐泡泡");
    }
}

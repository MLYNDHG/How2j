package J2SE.ZOO;

public class Cat extends Animal implements Pet{
    String Name;
    public Cat(){
        this("");
    }
    public Cat(String Name){
        super(4);
        this.Name=Name;
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public void play() {
        System.out.println("猫挑高");
    }
}

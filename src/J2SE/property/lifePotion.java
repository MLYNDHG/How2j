package J2SE.property;

public class lifePotion extends Item{
    @Override
    public void effect() {
        System.out.println("使用血瓶可以回血");
    }

    @Override
    public boolean disposable() {
        return true;
    }
}

package J2SE.property;
//武器类（weapon）继承物品类（Item）
public class Weapon extends Item {
    int damage;//伤害

    public static void main(String[] args) {
        Weapon infinityEdge=new Weapon();//无尽之刃
        infinityEdge.name="无尽之刃";
        infinityEdge.price=3600;
        infinityEdge.damage=65;
    }

    @Override
    public boolean disposable() {
        return false;
    }
}

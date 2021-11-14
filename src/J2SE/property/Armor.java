package J2SE.property;

//护甲类（Armor）继承物品类（Item）
public class Armor extends Item {
    int armorHp;//护甲值

    public static void main(String[] args) {
        Armor suozijia=new Armor();
        suozijia.price=500;
        suozijia.armorHp=40;
        Armor bujia=new Armor();
        bujia.price=300;
        bujia.armorHp=15;
    }

    @Override
    public boolean disposable() {
        return false;
    }
}

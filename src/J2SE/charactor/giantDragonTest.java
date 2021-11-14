package J2SE.charactor;

public class giantDragonTest {
    public static void main(String[] args) {

        //饿汉单例
        giantDragon dragon1= giantDragon.getInstance();
        giantDragon dragon2= giantDragon.getInstance();
        giantDragon dragon3= giantDragon.getInstance();
        System.out.println(dragon1==dragon2);
        System.out.println(dragon3==dragon2);
        //懒汉单例
        giantDragon dragon4= giantDragon.getlLanInstance();
        giantDragon dragon5= giantDragon.getlLanInstance();
        giantDragon dragon6= giantDragon.getlLanInstance();
        System.out.println(dragon4==dragon5);
        System.out.println(dragon6==dragon4);

    }
}

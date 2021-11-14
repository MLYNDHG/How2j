package J2SE.charactor;

//辅助类
public class Support extends Hero implements healer{
    public void heal(){
        System.out.println(name+"给某人加血");
    }
    public void heal(Hero h1){
        System.out.println(name+"给"+h1.name+"加血");
    }
    public void heal(Hero h1,int hp){
        System.out.println(name+"给"+h1.name+"加了"+hp+"的血量");
    }



    public static void main(String[] args) {
        Support sup=new Support();
        sup.name="娑娜";

        Hero h1=new Hero();
        h1.name="卢仙";

        sup.heal();
        sup.heal(h1);
        sup.heal(h1,1000);
    }
}

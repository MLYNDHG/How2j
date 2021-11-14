package J2SE.charactor;

import J2SE.Interface.Moral;
//接口与继承系列教材 （九）- JAVA 抽象类详解
public class ADHero extends Hero implements AD, Moral {
    public void attack(){
        System.out.println(name+"进行了一次攻击");
    }
    public void attack(Hero h1){
        System.out.println(name+"对"+h1.name+"进行了一次攻击");
    }
    public void attack(Hero h1,Hero h2){
        System.out.println(name+"对"+h1.name+"和"+h2.name+"进行了一次攻击");
    }
    public void attack(Hero ...heros){
        for (Hero hero : heros) {
            System.out.println(name+"对"+hero.name+"进行了一次攻击");
        }

    }

    @Override
    public void die() {
        System.out.println("AD去世了");
    }

    @Override
    public void physicAttack() {
        System.out.println("进行了物理攻击");
    }
    //接口与继承系列教材 （五）- JAVA中的方法隐藏
    public static void battleWin(){
        System.out.println("ad battle Win!");
    }

    public static void main(String[] args) {
        ADHero ad=new ADHero();
        ad.name="卢仙";

        Hero h1=new Hero();
        h1.name="机器人";
        Hero h2=new Hero();
        h2.name="蛮子";
        Hero h3=new Hero();
        h3.name="光辉";
        ad.attack();
        ad.attack(h1);
        ad.attack(h1,h2);
        ad.attack(h1,h2,h3);

        ad.physicAttack();
        System.out.println("验证隐藏");
        ad.battleWin();
    }
}

package J2SE.charactor;

import J2SE.Interface.Moral;

public class Hero {
    // 面向对象系列教材 （二）- JAVA类的属性
    public String name;
    public float hp;
    public float armor;
    public int moveSpeed;
    public int damage;

    //类和对象系列教材 （九）- JAVA的类属性，静态属性
    static String copyRight;

    //面向对象系列教材 （三）- JAVA类的方法
    void carry(){
        System.out.println("carry全场!");
    }
    float getArmor(){
        return armor;
    }
    void addSpeed(int speed){
        moveSpeed+=speed;
    }
    void legendary(){
        System.out.println("超神了！");
    }
    float getHp(){
        return hp;
    }
    void recovery(float blood){
        hp+=blood;
    }
    //类和对象系列教材 （四）- 怎么使用 JAVA 构造方法？
    public Hero(){

    }
    public Hero(String name){
        this.name=name;
    }
    public Hero(String name,float hp){
        this(name);
        this.hp=hp;
    }
    public Hero(String heroName,float heroHP,float heroArmor,int heroMoveSpeed){
        this(heroName,heroHP);
        armor=heroArmor;
        moveSpeed=heroMoveSpeed;
    }

    //类和对象系列教材 （十）- JAVA的类方法，静态方法
    public void die(){
        System.out.println(this.name+"被击杀了");
    }
    //多线程系列教材 （一）- JAVA 创建一个线程的三种方式
    public boolean isDie(){
        return hp>0?false:true;
    }
    public void attackHero(Hero h){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        h.hp-=h.damage;

        if(h.isDie()){
            System.out.println(h.name+"被击杀了");
            return ;
        }
        System.out.println(name+"正在攻击"+h.name+","+ h.name+"的血量变成了"+h.hp);
    }
    //
    public static void battleWin(){
        System.out.println("battle Win!");
    }

    public static void main(String[] args) {
        Hero.copyRight="英雄联盟拳头公司";

        Hero h1=new Hero("盖伦");
        System.out.println("heroname:"+h1.name);
        System.out.println("copyRight:"+h1.copyRight);

        Hero h2=new Hero("提莫");
        System.out.println("heroname:"+h2.name);
        System.out.println("copyRight:"+h2.copyRight);

        h2.copyRight= "Blizzard Entertainment Enterprise";
        System.out.println("copyRight:"+h1.copyRight);
        System.out.println("copyRight:"+h2.copyRight);

        h2.die();
        h2.battleWin();

        ADHero ad=new ADHero();
        Hero h=ad;
        AD adi=(AD) h;
        //APHero ap=(APHero) adi;   验证不同类型强转会报错

        // 接口与继承系列教材 （四）- 什么是JAVA的多态？
        Hero H1=new Hero();
        Moral m1=new ADHero();
        Moral m2=new APHero();
        Moral m3=new ADAPHero();
        System.out.println("验证多态");
        h1.kill(m1);
        h1.kill(m2);
        h1.kill(m3);
    }
    // 接口与继承系列教材 （四）- 什么是JAVA的多态？
    public void kill(Moral m){
        m.die();
    }
}

package J2SE.property;

//可以有多个类，但只能有一个public的类（不包含内部类），并且public的类名必须与文件名相一致。
//
//理论上来讲: 一个java源文件 ,只能有一个public类, 并且该类与java源文件同名, 且区分大小写.
public abstract class Item {
    String name;
    int price;
    //接口与继承系列教材 （九）- JAVA 抽象类详解
    public abstract boolean disposable();
    public void buy(){
        System.out.println("购买");
    }
    public  void finalize(){
        System.out.println("当前对象正在被回收");
    }
    public boolean equals(Object o){
        if(o instanceof Item){
            Item i=(Item) o;
            if(i.price==this.price){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    public void effect(){
        System.out.println("使用物品可以有效果");
    }
    public static void main(String[] args) {
        //抽象后就不可以实例化   可通过匿名类来直接使用  即当场给抽象方法当场集成但没有类名（匿名类）
        Item potion=new Item(){
            public  boolean disposable(){
                System.out.println("???");
                return true;
            }
        };
//        potion.name="血瓶";
//        potion.price=50;
//        Item shoe=new Item();
//        shoe.name="草鞋";
//        shoe.price=300;
//        Item sword=new Item();
//        sword.name="长剑";
//        sword.price=350;


//        System.out.println(potion.name.toString()+potion.price);


//        Object yan=new Item();
//        System.out.println(sword.equals(yan));
    }
}
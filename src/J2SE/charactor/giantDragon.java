package J2SE.charactor;
//类和对象系列教材 （十二）- 怎么写一个JAVA的饿汉式与懒汉式单例模式
//1.类的构造器为私有    其他地方就无法创建引用了（达成单例）
//2.静态属性静态方法直接类中初始化创建一个实例   其他地方就可以直接使用使用类名调用


//饿汉单例
    //创建类的时候就初始化单例
//懒汉单例
    //在调用getinstance时才初始化
public class giantDragon {
    //1
    private giantDragon(){

    }
    //2饿汉单例
    public static giantDragon instanceDragon=new giantDragon();
    public static giantDragon getInstance(){
        return instanceDragon;
    }

    //懒汉单例
    public  static giantDragon langiantDragon;
    public  static giantDragon getlLanInstance(){
        if(langiantDragon==null){
            langiantDragon=new giantDragon();
        }
        return langiantDragon;
    }
}

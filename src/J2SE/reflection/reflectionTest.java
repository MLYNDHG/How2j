package J2SE.reflection;
import J2SE.charactor.Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.ClosedSelectorException;

public class reflectionTest {
    public static Hero getHero(){
        return new Hero();
    }
    public static void main(String[] args) {
        try {
            //1.三种反射获取 类的类对象
            Class c1= Class.forName("J2SE.charactor.Hero");
            Class c2 =Hero.class;
            Class c3=new Hero().getClass();

            System.out.println(c1==c2);
            System.out.println(c3==c2);
            //2.创建对象
            try {
                Constructor constructor= c1.getConstructor();
                Hero hero= (Hero)constructor.newInstance();
                hero.name="timo";
                System.out.println(hero.name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //3.配置文件获取对象
            File file=new File("C:\\Study\\java\\How2j\\src\\J2SE\\reflection\\Hero.config");
            try (FileReader rf=new FileReader(file)){
                String className=null;
                char []all=new char[(int)(file.length())];
                rf.read(all);
                className=new String(all);
                Class c4=Class.forName(className);
                Constructor constructor=c4.getConstructor();
                Hero h=(Hero) constructor.newInstance();
                h.name="傻逼";
                System.out.println(h.name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //4.通过反射修改类对象属性值
            Hero hero=new Hero();
            hero.name="大傻逼";
            try {
                //getDeclaredField   可获得非继承的public  private属性  (但private属性只能获得不能修改  除非加上setAccessible(true))
                //getField           可获得继承的public属性
                Field field=hero.getClass().getDeclaredField("name");
                field.set(hero,"小傻逼");
                System.out.println(hero.name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //5.通过反射调用对象方法
            try {
                Method method=hero.getClass().getMethod("setName",String.class);
                method.invoke(hero,"伞兵");
                System.out.println(hero.name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //6.通过配置文件反射实例化多个对象并调用对象的方法
            File file1=new File("C:\\Study\\java\\How2j\\src\\J2SE\\reflection\\HeroMethod.config");
            try (FileReader rf=new FileReader(file1)){
                String classContent=null;
                char []all=new char[(int)(file1.length())];
                //将内容读取到字符数组
                rf.read(all);
                //将字符数组转化成字符串
                classContent=new String(all);
                //将内容分开
                String []classNames=classContent.split("\r\n");
                String Hero1ClassName=classNames[0];
                String Hero1Name=classNames[1];
                String Hero2ClassName=classNames[2];
                String Hero2Name=classNames[3];
                //根据反射实例化Hero1  并设置name字段为Hero1Name
                Class Hero1Class=Class.forName(Hero1ClassName);
                Constructor constructor1=Hero1Class.getConstructor();
                Object Hero1=constructor1.newInstance();
                Field field1=Hero1Class.getField("name");
                field1.set(Hero1,Hero1Name);
                //根据反射实例化Hero2   并设置name字段为Hero2Name
                Class Hero2Class=Class.forName(Hero2ClassName);
                Constructor constructor2=Hero2Class.getConstructor();
                Hero Hero2=(Hero) constructor2.newInstance();
                Field field2=Hero2.getClass().getField("name");
                field1.set(Hero2,Hero2Name);
                //根据反射获得对象方法并调用
                Method method=Hero1.getClass().getMethod("attackHero",Hero.class);
                method.invoke(Hero1,Hero2);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

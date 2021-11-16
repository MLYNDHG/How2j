package J2SE.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GUITest {
    static class point{
        int X;
        int Y;
    }
    public static void main(String[] args) {
        JFrame f=new JFrame("LOL");
        f.setSize(800,800);
        point p=getPostion();
        if (p==null){
            f.setLocation(300,150);
        }else{
            f.setLocation(p.X,p.Y);
        }
        f.setLayout(null);
        JButton jb=new JButton("潘多拉");
        jb.setBounds(50,50,280,30);
        f.add(jb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        new SavingPostionThread(f).start();
    }
    public static point getPostion(){
        point p=null;//静态内部类  可直接实例化   非静态内部类则须实例化外部类再实例化非静态内部类
        File file =new File("C:\\Study\\java\\How2j\\src\\J2SE\\GUI\\position.txt");
        try (FileInputStream fis=new FileInputStream(file); DataInputStream dis=new DataInputStream(fis);){
            int X =dis.readInt();
            int Y =dis.readInt();
            p=new point();
            p.X=X;
            p.Y=Y;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}

package J2SE.GUI;

import javax.swing.*;
import java.io.*;

public class SavingPostionThread extends Thread {
    File file=new File("C:\\Study\\java\\How2j\\src\\J2SE\\GUI\\position.txt");
    private JFrame f=new JFrame();
    SavingPostionThread (JFrame f){
        //将测试的窗口绑定到线程
        this.f=f;
    }

    @Override
    public void run() {
        //做一件事情  将位置信息记录到文件 100ms记录一次
        while (true){
            int X=f.getX();
            int Y=f.getY();
            try (FileOutputStream fos=new FileOutputStream(file); DataOutputStream dos=new DataOutputStream(fos);){
                dos.writeInt(X);
                dos.writeInt(Y);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

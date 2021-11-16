package J2SE.Socket;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class receiveThreadGUI extends Thread{
    private Socket s;
    private JFrame frame;
    public  receiveThreadGUI(Socket s,JFrame frame){
        this.s=s;
        this.frame=frame;
    }

    @Override
    public void run() {
        InputStream is= null;
        try {
            is = s.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            while(true){
                String msg=dis.readUTF();
                System.out.println("发来了消息:"+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

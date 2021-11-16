package J2SE.Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class receiveThread extends Thread{
    private Socket s;
    public  receiveThread(Socket s){
        this.s=s;
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

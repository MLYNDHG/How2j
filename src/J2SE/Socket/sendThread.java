package J2SE.Socket;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class sendThread  extends  Thread{
    private Socket s;
    public sendThread(Socket s){
        this.s=s;
    }

    @Override
    public void run() {
        try {
            OutputStream os=s.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            while(true){
                System.out.println("发送消息：");
                Scanner sc=new Scanner(System.in);
                String msg=sc.next();
                dos.writeUTF(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

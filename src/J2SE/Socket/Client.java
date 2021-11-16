package J2SE.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s=new Socket("127.0.0.1",8888);
            System.out.println(s);
//            //接收消息
//            OutputStream os=s.getOutputStream();
//            DataOutputStream dos=new DataOutputStream(os);
//            //发送消息
//            InputStream is=s.getInputStream();
//            DataInputStream dis=new DataInputStream(is);
//            while (true){
//                System.out.print("发消息:");
//                Scanner sc=new Scanner(System.in);
//                String str=sc.next();
//                dos.writeUTF(str);
//
//                str=dis.readUTF();
//                System.out.println("Server发来了消息:"+str);
//            }
            //多线程聊天室
            new sendThread(s).start();
            new receiveThread(s).start();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

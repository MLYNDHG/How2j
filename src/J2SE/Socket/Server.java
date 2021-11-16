package J2SE.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Server {
    //准备一个随机回复
    public static List<String> cannotUnderstand=new ArrayList<>();
    static {
        cannotUnderstand.add("听求不懂啊");
        cannotUnderstand.add("说人话");
        cannotUnderstand.add("再说一遍？");
        cannotUnderstand.add("大声点");
        cannotUnderstand.add("老子在忙，一边玩儿去");
    }
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(8888);
            System.out.println("正在监听8888端口");
            Socket s=ss.accept();
            System.out.println("有连接过来："+s);
//            //接收消息   单线程聊天室
//            InputStream is=s.getInputStream();
//            DataInputStream dis=new DataInputStream(is);
//            //发送消息
//            OutputStream os=s.getOutputStream();
//            DataOutputStream dos=new DataOutputStream(os);

//            while(true){
//                String msg=dis.readUTF();
//                System.out.println("Client发来了消息:"+msg);
////                System.out.print("发消息:");
////                Scanner sc=new Scanner(System.in);
////                msg=sc.next();
//                List<dictionary> ds=new dictionaryDao().getDictionaryList(msg);
//                if(ds.isEmpty()){
//                    Collections.shuffle(cannotUnderstand);
//                    msg=cannotUnderstand.get(0);
//                }else{
//                    msg=ds.get(0).response;
//                }
//                dos.writeUTF(msg);
//            }


            //多线程 聊天室
            new sendThread(s).start();
            new receiveThread(s).start();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

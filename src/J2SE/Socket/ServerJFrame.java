package J2SE.Socket;

import J2SE.GUI.GUITest;
import J2SE.GUI.SavingPostionThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJFrame {
    static JFrame f=new JFrame("Server");
    private static void openChatWindow(){

        f.setSize(800,800);
        f.setLocation(300,150);
        f.setLayout(null);
        //历史记录文本框
        JTextArea jtHistory=new JTextArea();
        jtHistory.setBounds(10,10,760,580);
        f.add(jtHistory);

        //发送消息文本框
        JTextArea jtSend=new JTextArea();
        jtSend.setBounds(10,600,600,150);
        f.add(jtSend);
        //发送按钮
        JButton jb=new JButton("发送");
        jb.setBounds(620,600,150,150);
        f.add(jb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        //开启聊天  获取消息
        try {
            ServerSocket ss=new ServerSocket(8888);
            System.out.println("正在监听端口8888");
            Socket s= ss.accept();
            System.out.println("有连接过来");
            new Thread(){
                @Override
                public void run() {
                    while(true){
                        try {
                            InputStream is = s.getInputStream();
                            DataInputStream dis=new DataInputStream(is);
                            String text=dis.readUTF();
                            jtHistory.append("Client："+text+"\r\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            //发送消息
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text=jtSend.getText();
                    jtHistory.append("Server："+text+"\r\n");
                    try {
                        OutputStream os= s.getOutputStream();
                        DataOutputStream dos=new DataOutputStream(os);
                        dos.writeUTF(text);
                        //发送后清空输出控件
                        jtSend.setText("");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
    public static void main(String[] args) {
        openChatWindow();
    }
}

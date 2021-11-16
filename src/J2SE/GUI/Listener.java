package J2SE.GUI;

import javax.swing.*;
import java.awt.event.*;

public class Listener {
    public static void main(String[] args) {
        JFrame f=new JFrame("LOL");
        f.setSize(800,800);
        f.setLocation(300,150);
        f.setLayout(null);
        JButton jb=new JButton("潘多拉");
        jb.setBounds(260,570,280,60);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("C:\\Study\\java\\How2j\\src\\J2SE\\GUI\\Source\\shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
        //监听按键
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);
            }
        });
        //监听键盘
        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 37) {
                    l.setLocation(l.getX() - 10, l.getY());
                }
                if (e.getKeyCode() == 38) {
                    l.setLocation(l.getX() , l.getY()- 10);
                }
                if (e.getKeyCode() == 39) {
                    l.setLocation(l.getX() + 10, l.getY());
                }
                if (e.getKeyCode() == 40) {
                    l.setLocation(l.getX() , l.getY()+ 10);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        //监听鼠标
        f.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //监听鼠标  按需求实现接口
        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });

        f.add(l);
        //f.add(jb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

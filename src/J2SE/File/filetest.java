package J2SE.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//C:\Users\马里亚纳大海沟\Desktop\安排.png
public class filetest {
    public static void main(String[] args) {
        File file1=new File("C:\\Users\\马里亚纳大海沟\\Desktop\\安排.png");
        System.out.println( file1.getAbsoluteFile());
//        System.out.println(file1.renameTo());
        try{
            FileInputStream fis = new FileInputStream(file1);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

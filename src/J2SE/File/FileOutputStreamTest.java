package J2SE.File;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try{
            File f=new File("C:\\Users\\马里亚纳大海沟\\Desktop\\wo.txt");
            byte data[]={100,101};
            FileOutputStream fos=new FileOutputStream(f);
            fos.write(data);
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        //文件目录不存在情况
        try{
            File f=new File("C:\\Users\\马里亚纳大海沟\\Desktop\\shabi\\shabi\\wo.txt");
            byte data[]={100,101};
            File dir=f.getParentFile();
            if(!dir.exists()){
                dir.mkdirs();
            }
            FileOutputStream fos=new FileOutputStream(f);
            fos.write(data);
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

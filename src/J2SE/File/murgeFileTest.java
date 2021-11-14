package J2SE.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//将分割的文件合并到一个文件（源文件）
//读入流-》存到字节数组-》写入流
public class murgeFileTest {
    public static void main(String[] args) {
        murgeFile("C:/Users/马里亚纳大海沟/Desktop/分割","安排.png");
    }
    public static void murgeFile(String folder, String srcFile){
        try{
            File destFile=new File(folder,srcFile) ;
            FileOutputStream fos=new FileOutputStream(destFile);
            int index =0;
            while(true){
                File mFile=new File(folder,srcFile+"-"+index++);
//                File dir=mFile.getParentFile();
//                if(!dir.exists())
//                    dir.mkdirs();
                byte fileContent[]=new byte[(int)mFile.length()];
                if (!mFile.exists())
                    break;
                FileInputStream fis=new FileInputStream(mFile);
                fis.read(fileContent);
                fos.write(fileContent);
                fis.close();
                fos.flush();
                System.out.printf("把子文件 %s写出到目标文件中%n",mFile);
            }
            fos.close();
            System.out.printf("最后目标文件的大小：%,d字节" , destFile.length());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package J2SE.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
//文件分割存储
//1.打开(File f=new File(src);)要被分割的文件，读取（FileInputStream-》read）保存到字节流数组中
//2.打开将分割文件，输出（FileOutputStream-》write）字节流到文件
public class splitFileTest {
    public static void main(String[] args) {
        File f=new File("C:/Users/马里亚纳大海沟/Desktop/安排.png");
        int eachSize = 10 * 1024; // 10k
        splitFile(f,eachSize);
    }
    //将文件分割
    //srcFile   源文件
    //eachSize  分割的每个文件大小
    public static void splitFile(File srcFile,int eachSize){
        //判断文件长度是否可以分割
        if(srcFile.length()==0){
            throw new RuntimeException("文件长度为0，不可分割");
        }
        //字节数组存储读取的文件流字节
        byte []fileContent=new byte[(int)srcFile.length()];
        try{
            FileInputStream fi=new FileInputStream(srcFile);
            fi.read(fileContent);
            fi.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("文件流读取成功");
        }
        //开始写入
        //判断分割文件个数
        int fileNumber=0;
        if(srcFile.length()%eachSize==0){
            fileNumber=(int)(srcFile.length()/eachSize);
        }else{
            fileNumber=(int)(srcFile.length()/eachSize)+1;
        }
        for (int i = 0; i < fileNumber; i++) {
            String eachFileName= srcFile.getName()+"-"+i;
            File eachFile=new File(srcFile.getParent()+"\\分割",eachFileName);
            File dir=eachFile.getParentFile();
            if(!dir.exists()){
                dir.mkdirs();
            }
            byte []eachContent;
            if(i!=fileNumber-1){
                eachContent= Arrays.copyOfRange(fileContent,eachSize*i,eachSize*(i+1));
            }else{
                eachContent= Arrays.copyOfRange(fileContent,eachSize*i,fileContent.length);
            }
            try{
                FileOutputStream fo=new FileOutputStream(eachFile);
                fo.write(eachContent);
                fo.close();
                System.out.printf("输出子文件%s，其大小是 %d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}

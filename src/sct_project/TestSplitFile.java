package sct_project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 实现将文件分块保存项目  ★★★★★
 * 面向对象思想封装，分割
 */

public class TestSplitFile {

    //源头
    private File src;
    //文件大小
    private long len;
    //目的地
    private String destDir;
    //所有分割后的文件存储路径
    private List<String> destPaths;
    //每块大小
    private int blockSize;
    //块数
    private int size;

    public TestSplitFile(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();
        init();  //初始化形参以外的必要变量

    }

    /*构造器的重构*/
    public TestSplitFile(String srcPath, String destDir){
        this(srcPath,destDir,1024);
    }

    /*分割文件
    * 计算每一块的起始位置和大小*/
    public void split() throws IOException {

        //起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int)(blockSize > len?len:blockSize);
        for (int i=0; i<size; i++){
            beginPos = i*blockSize;
            if (i == size-1){  //最后一块
                actualSize = (int)len;
            }else {
                actualSize = blockSize;
                len -= actualSize;  //总剩余
            }
            splitDetail(i,beginPos,actualSize);
        }
    }

    /*分割具体实现*/
    private void splitDetail(int i, int beginPos, int actualSize) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(this.src,"r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");
        //随机读取
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1){
            if (actualSize > len){
                raf2.write(flush,0,len);
                actualSize -= len;
            }else {
                raf2.write(flush,0,actualSize);
                break;
            }
        }
        raf.close();
        raf2.close();

    }

    /*初始化*/
    public void init(){
        //文件大小
        this.len = src.length();
        //块数
        this.size = (int)(len*1.0/blockSize);
        //路径,先生成好路径位置
        for (int i=0; i<size; i++){
            this.destPaths.add(this.destDir+ "/" + this.src.getName() + "-" + i );
        }
    }

    /*文件的合并,利用联合流*/
    public void merge(String destPath) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));

        //输入流,联合流 ☆☆☆
        Vector<InputStream> vi = new Vector<InputStream>();
        SequenceInputStream sis = null;
        for (int i=0; i<destPaths.size(); i++){
            vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
        }
        sis = new SequenceInputStream(vi.elements());

        //操作
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = sis.read(flush)) != -1){
            os.write(flush,0,len);
        }
        os.flush();
        sis.close();
        os.close();

    }

    public static void main(String[] args) throws IOException {
        TestSplitFile tsf = new TestSplitFile("src/sct_project/TestSplitFile.java","src/shiyan",1024);
        tsf.split();
        tsf.merge("src/shiyan/TSF.java");
    }
}

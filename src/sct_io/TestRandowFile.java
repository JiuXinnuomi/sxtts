package sct_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 测试随机读取和写入流 ★★★
 * RandomAccessFile
 */

public class TestRandowFile {

    public static void main(String[] args) throws IOException {

        RandomReadPart();
    }

    /*随机读取，读取指标后的所有内容*/
    public static void RandomReadAll() throws IOException {

        RandomAccessFile raf = new RandomAccessFile(new File("src/sct_io/images/pigu.mp4"),"r");
        //随机读取
        raf.seek(2);
        //操作
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1){
            System.out.println(new String(flush,0,len));
        }

        raf.close();
    }

    /*分块思想，读取指标后指定大小内容*/
    public static void RandomReadRange() throws IOException {

        RandomAccessFile raf = new RandomAccessFile(new File("src/sct_io/images/pigu.mp4"),"r");
        //起始位置,大小
        int beginPos = 2 + 1024;
        int acttualSize = 1026;
        //随机读取
        raf.seek(beginPos);
        //操作
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1){

            if (acttualSize > len){  //获取本次所有读取内容
                System.out.println(new String(flush,0,len));
                acttualSize -= len;
            }else{
                System.out.println(new String(flush,0,acttualSize));
                break;
            }
        }

        raf.close();
    }

    /*分块思想，具体分多少块*/
    public static void RandomReadPart(){

        File src = new File("src/sct_io/images/pigu.mp4");
        long len = src.length();  //总长度
        int blockSize = 1024*10;  //每块大小
        int size = (int)Math.ceil(len*1.0/blockSize);  //分多少块
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
            System.out.println(i + "---→" + size + "---→" + actualSize + "---→" + len);
        }
    }

}

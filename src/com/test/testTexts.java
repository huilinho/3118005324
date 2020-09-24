package com.test;

import com.code.ED;
import com.code.FileProcessor;
import com.exception.FileException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author huilin
 * @version 1.0
 * @date 2020/9/23 15:42
 */
public class testTexts {

    String origFilePath = "src/resources/orig.txt";
    String ansFilePath = "src/resources/ans.txt";

    //测试全部文件
    @Test
    public void testAll() throws IOException, FileException {
        String[] filePaths = new String[]{
                "src/resources/orig_0.8_add.txt",
                "src/resources/orig_0.8_del.txt",
                "src/resources/orig_0.8_dis_1.txt",
                "src/resources/orig_0.8_dis_10.txt",
                "src/resources/orig_0.8_dis_15.txt",
        };

        for (String file : filePaths) {
            double result = ED.getResult(origFilePath,file);
            System.out.println(file +"与原文件重复率为"+result);
            FileProcessor.stringToFile(result,ansFilePath);
        }
    }
    //测试add文件
    @Test
    public void testAdd() throws IOException,FileException {
        String fileName = "src/resources/orig_0.8_add.txt";
        double result = ED.getResult(origFilePath,fileName);
        System.out.println(fileName +"与原文件重复率为"+result);
        FileProcessor.stringToFile(result,ansFilePath);
    }

    //测试del文件
    @Test
    public void testDelete() throws IOException,FileException {
        String fileName = "src/resources/orig_0.8_del.txt";
        double result = ED.getResult(origFilePath,fileName );
        System.out.println(fileName +"与原文件重复率为"+result);
        FileProcessor.stringToFile(result,ansFilePath);
    }

    //测试dis1文件
    @Test
    public void testDis1() throws IOException,FileException {
        String fileName = "src/resources/orig_0.8_dis_1.txt";
        double result = ED.getResult(origFilePath,fileName );
        System.out.println(fileName +"与原文件重复率为"+result);
        FileProcessor.stringToFile(result,ansFilePath);
    }

    //测试dis10文件
    @Test
    public void testDis10() throws IOException,FileException {
        String fileName = "src/resources/orig_0.8_dis_10.txt";
        double result = ED.getResult(origFilePath,fileName );
        System.out.println(fileName +"与原文件重复率为"+result);
        FileProcessor.stringToFile(result,ansFilePath);
    }

    //测试dis15文件
    @Test
    public void testDis15() throws IOException,FileException {
        String fileName = "src/resources/orig_0.8_dis_15.txt";
        double result = ED.getResult(origFilePath,fileName );
        System.out.println(fileName +"与原文件重复率为"+result);
        FileProcessor.stringToFile(result,ansFilePath);
    }

}

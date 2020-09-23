package com.test;

import com.code.ED;
import com.exception.FileException;
import org.junit.Test;

import java.io.IOException;

/**
 * @author huilin
 * @version 1.0
 * @date 2020/9/23 20:12
 */

//测试异常处理
public class testException {
    String origFilePath = "";

    @Test
    public void TestNull() throws IOException, FileException {
        double result = ED.getResult(" "," " ); //传入两个空文件名进去
        System.out.println(result);
    }
    @Test
    public void Test() throws IOException, FileException {
        double result = ED.getResult("D:/tests/empty1.txt","D:/tests/empty2.txt" ); //传入空文件进去
        System.out.println(result);
    }
}

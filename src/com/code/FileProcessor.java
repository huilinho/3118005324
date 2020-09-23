package com.code;

import com.exception.FileException;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author huilin
 * @version 1.0
 * @date 2020/9/21 15:33
 */

//处理文件的接口
public interface FileProcessor {

    //通过文件的绝对路径或相对路径读取文件，并转换成字符串
    static String fileToString(String filePath) throws IOException, FileException {
        if(filePath==null ||" ".equals(filePath)){
            throw new FileException("文件路径为空");
        }
        FileInputStream fileInputStream = new FileInputStream(filePath);  //根据文件路径，找到文件，创建文件输入流
        BufferedReader bf = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)); // BufferedReader 可以一次读取一行数据
        if(bf.readLine()==null){
            throw new FileException("文件内容为空");
        }
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line=bf.readLine())!=null){
             stringBuilder.append(line); //用StringBuilder对象读取每一行，并加到stringBuilder里
        }
        bf.close(); //关闭
        return stringBuilder.toString(); //返回一个与缓冲器bf内容相同的字符串
    }

    //将要保存的文本写入指定的地址
    static void stringToFile(double text, String filePath) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));){
           writer.write(String.valueOf(text));
       }catch (IOException e){
           e.printStackTrace();
       }
    }
}

package com.code;

import com.exception.FileException;

import java.io.IOException;

/**
 * @author huilin
 * @version 1.0
 * @date 2020/9/21 14:26
 */
//主程序入口
public class main {
    public static void main(String[] args) {
         double result = 0.00;
         try{
             result =  ED.getResult(args[0],args[1]);
        }catch (IOException | FileException e){
            e.printStackTrace();
        }finally{
             //如果输入了第三个参数，就将结果写入第三个参数所指的文件
             if(args.length>2 && args[2]!=null){
                 FileProcessor.stringToFile(result,args[2]);
                 System.out.format("结果已成功写入文件:%s 中",args[2]);
             }
             //如果没有输入第三个参数，将结果打印在控制台上
             else{
                 System.out.println(result);
             }
        }
    }
}

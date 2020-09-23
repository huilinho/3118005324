package com.code;


import com.exception.FileException;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author huilin
 * @version 1.0
 * @date 2020/9/21 14:53
 */

/*
*
* todo 实现最小编辑距离算法,完成字符串匹配运算
*
*/
public class ED {
    public static  final int LENGTH = 2;

    //最短编辑距离算法的实现
    public static double StringED(char[] orig , char[] dest) throws FileException {
        int origLength = orig.length;
        int destLength = dest.length;
        if (origLength==0 || destLength==0){
            throw new FileException("The text is empty");
        }
        int[][] edit = new int[LENGTH][destLength+1];

        for (int i = 0; i < LENGTH; i++) {
            for(int j = 0 ; j < destLength ; j++){
                edit[i][j] = Integer.MAX_VALUE;
            }
        }
        edit[0][0] = 0;
        for(int i = 1 ; i < LENGTH ; i++){
            edit[i][0] = edit[i-1][0]+1; //第一列从0开始递增，每次递增加1
        }

        for(int j = 1 ; j < destLength ; j++){
            edit[0][j] = edit[0][j-1]+1; //第一行从0开始递增，每次递增加1
        }

        //使用动态规划方法
        for (int i = 0 ; i < origLength ; i++){
            for(int j = 0 ; j < destLength ; j++){
                if(orig[i] == dest[j]) {
                    //若当前字匹配，则编辑距离不变
                    edit[(i+1)%2][j+1] = edit[i%2][j] ;
                }
                else{
                    //字符不匹配，有三种情况修改：增加、删除、修改
                    edit[(i+1)%2][j+1] = Math.min(Math.min(edit[(i + 1)%2][j], edit[i%2][j + 1]), edit[i%2][j]) + 1;
                }
            }
        }
        return (double)(destLength-edit[origLength%2][destLength])/destLength;
    }

    public static double getResult(String origPath,String destPath) throws IOException, FileException {
        double result = 0.00;
        String originText = FileProcessor.fileToString(origPath); //参数args[0]为源文件地址，获取原文件的文本
        String destText = FileProcessor.fileToString(destPath); //参数args[1]为待检验文件地址
        //对源文件和目标文件进行预处理(将空格和非中英文数部分去除)
        char[] orig = PatternUtil.preProgress(originText);
        char[] dest = PatternUtil.preProgress(destText);

        result = ED.StringED(orig,dest); //获得匹配结果
        BigDecimal bd = new BigDecimal(result);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP); //对结果保留到小数后两位
        result = bd.doubleValue();
        return result;
    }
}


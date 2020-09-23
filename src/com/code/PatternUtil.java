package com.code;

import java.util.regex.Pattern;

/**
 * @author huilin
 * @version 1.0
 * @date 2020/9/23 13:24
 */
//匹配非中英文数字的字符，将这些字符全部清除掉，并除去空格
public class PatternUtil {
    /***
     * 去除空格等非中英文数字字符
     */
    public static char[] preProgress(String text) {
        //去除文本中所有非中文英文数字的字符
        String patternText = "[\\u3002|\\uff1f|\\uff01|\\uff0c|\\u3001|\\uff1b|\\uff1a|\\u201c|\\u201d|\\u2018|\\u2019|\\uff08|\\uff09|\\u300a|\\u300b|\\u3008|\\u3009|\\u3010|\\u3011|\\u300e|\\u300f|\\u300c|\\u300d|\\ufe43|\\ufe44|\\u3014|\\u3015|\\u2026|\\u2014|\\uff5e|\\ufe4f|\\uffe5|\\uff0d \\uff3f|\\u002d]?";
        Pattern pattern = Pattern.compile(patternText);
        text = pattern.matcher(text).replaceAll("").trim();
        char[] result = text.toCharArray();
        return result;
    }
}

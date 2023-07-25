package com.zyh.music.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: music
 * @package: com.zyh.music.utils
 * @className: ImageNameUtil
 * @author: A_liar.
 * @date: 2023/6/30 10:23
 * @version: 1.0
 * @description: 注释
 */
public class ImageNameUtil {
    public static String getImageName() {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");
        System.out.println("获取当前时间："+date);
        return simpleDateFormat.format(date);
    }
}

package com.newheart.utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hanjie
 * @date 2019/9/29 10:27
 */
@Slf4j
public class DateUtils {

    private static SimpleDateFormat DateFormat_24H = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

    private static SimpleDateFormat DateFormat= new SimpleDateFormat("YYYY-MM-DD");

    /**
     * Date类型转为指定格式的String类型
     * @param date
     * @return
     */
    public static String DateToString24H(Date date){
        return DateFormat_24H.format(date);
    }

    public static String DateToString(Date date){
        return DateFormat.format(date);
    }

    /**
     * unix时间戳转为指定格式的String类型
     * @param timestamp
     * @return
     */
    public static String TimestampToString(long timestamp){
        Date date = new Date(timestamp * 1000);
        return DateFormat_24H.format(date);
    }

    /**
     * 将日期转换为时间戳(unix时间戳,单位秒)
     */
    public static long DateToTimestamp(Date date){
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp.getTime() / 1000;
    }

    /**
     * String转换为Date
     * @param source
     * @return
     */
    public static Date StringToDate(String source){
        Date date = null;
        try {
            date = DateFormat_24H.parse(source);
        } catch (ParseException e) {
            log.info("StringToDate——异常");
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前时间String
     */
    public static String currentFormatDate() {
        return DateFormat_24H.format(new Date());
    }

    /**
     * 获取当前时间戳
     */
    public static long currentTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     *获取当前系统时间戳
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}

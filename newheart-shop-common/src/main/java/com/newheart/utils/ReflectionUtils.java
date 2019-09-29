package com.newheart.utils;

import com.newheart.common.entity.TestEntity;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author hanjie
 * @date 2019/9/29 13:14
 */
public class ReflectionUtils {

     /**获取该类和父类的属性*/
    public static String thisAndSuperField(Object object){
        Class<?> classInfo = object.getClass();
        return getField(classInfo.getSuperclass())+","+getField(classInfo);
    }

    public static String getField(Class<?> classInfo){
        Field[] fields = classInfo.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <fields.length ; i++) {
            String name = fields[i].getName();
            sb.append(name);
            if (i <fields.length -1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String thisAndSuperFieldValue(Object object){
        Class<?> objectClass = object.getClass();
        return getFieldValue(objectClass.getSuperclass(),object) +"," + getFieldValue(objectClass,object) ;
    }

    public static String getFieldValue(Class<?> objectClass,Object object){
        Field[] fields = objectClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <fields.length ; i++) {
//          获取private值,需要设置为ture
            fields[i].setAccessible(true);
            try {
                Object value = fields[i].get(object);
                if (null != value && (value instanceof String || value instanceof Timestamp)){
                    sb.append("'");
                    sb.append(String.valueOf(value));
                    sb.append("'");
                }else {
                    sb.append(String.valueOf(value));
                }
                if (i<fields.length-1){
                    sb.append(",");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

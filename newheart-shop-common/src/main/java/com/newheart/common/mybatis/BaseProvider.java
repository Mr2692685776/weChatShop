package com.newheart.common.mybatis;

import com.newheart.utils.ReflectionUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author hanjie
 * @date 2019/9/29 14:27
 */
public class BaseProvider {

    public String save(Map<String,Object> map){
       final Object obj = map.get("obj");
       final String table = String.valueOf(map.get("table"));
        SQL sql = new SQL(){
            {
                INSERT_INTO(table);
                VALUES(ReflectionUtils.thisAndSuperField(obj),ReflectionUtils.thisAndSuperFieldValue(obj));
            }
        };
        return sql.toString();
    }
}

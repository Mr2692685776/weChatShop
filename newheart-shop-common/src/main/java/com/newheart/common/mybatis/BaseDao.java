package com.newheart.common.mybatis;

import feign.Param;
import org.apache.ibatis.annotations.InsertProvider;

/**
 * @author hanjie
 * @date 2019/9/29 13:13
 */
public interface BaseDao {

    @InsertProvider(type=BaseProvider.class,method="save")
    public void save(@Param("obj")Object obj, @Param("table")String table);
}

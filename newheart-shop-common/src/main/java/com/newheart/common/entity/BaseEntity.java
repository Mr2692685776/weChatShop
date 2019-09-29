package com.newheart.common.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

/**
 * @author hanjie
 * @date 2019/9/29 8:58
 */

@Data
public class BaseEntity {
    private Long id;
    private Timestamp created;
    private Timestamp updated;

}

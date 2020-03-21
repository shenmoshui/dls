package com.tao.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shentao
 * @date 2020-03-21
 */
@Getter
@Setter
public class LogEntity extends BaseEntity{

    private String level;

    private String logger;

    private String message;

    private String timestamp;
}
